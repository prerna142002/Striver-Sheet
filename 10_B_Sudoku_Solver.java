class Solution {

    boolean isSafe(int i, int j, char target, char[][] board) {
        for (int x = 0; x < board.length; x++) {
            if (board[x][j] == target)
                return false;
            if (board[i][x] == target)
                return false;

            if (board[3 * (i / 3) + x / 3][3 * (j / 3) + x % 3] == target) return false;    
        }

        return true;
    }

    boolean solve(char[][] board) {

        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                if(board[a][b] != '.') continue;
                for (char val = '1'; val <= '9'; val++) {
                    if (isSafe(a, b, val, board)) {
                        board[a][b] = val;
                        if (solve(board)) {
                            return true;
                        } else board[a][b] = '.';

                    }
                } 
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
