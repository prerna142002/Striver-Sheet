class Solution {

    List<List<String>> list;

    boolean isSafe(int x, int y, int size, String[][] board) {
        
        // Horizontally and Vertically
        for (int i = 0; i < size; i++) {
            if (board[x][i] == "Q")
                return false;
            if (board[i][y] == "Q")
                return false;
        }

        // Vertically left up
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q")
                return false;
        }
        // Vertically right up
        for (int i = x, j = y; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == "Q")
                return false;
        }
        // Vertically left down
        for (int i = x, j = y; i < size && j >= 0; i++, j--) {
            if (board[i][j] == "Q")
                return false;
        }
        // Vertically right down
        for (int i = x, j = y; i < size && j < size; i++, j++) {
            if (board[i][j] == "Q")
                return false;
        }
        return true;
    }

    void solve(int i1, int j1, int count, int size, String[][] board) {
        if (count == 0) {
            ArrayList<String> str = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                String boardStr = "";
                for (int j = 0; j < size; j++) {
                    boardStr += board[i][j];
                }
                str.add(boardStr);
            }
            list.add(str);
            return;
        }

        if (i1 >= size || j1 >= size)
            return;

        for (int a = 0; a < size; a++) {
            if (isSafe(a, j1, size, board)) {
                board[a][j1] = "Q";
                solve(a, j1+1, count - 1, size, board);
                board[a][j1] = ".";
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        String[][] board = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = ".";
            }
        }
        solve(0, 0, n, n, board);
        return list;
    }
}
