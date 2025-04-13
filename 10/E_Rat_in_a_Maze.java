class Solution {
    
    ArrayList<String> list;
    int[] dirX = {1,0,0,-1},
          dirY = {0,-1,1,0};
    String[] dirPos = {"D","L","R","U"};      
    
    void solve(int i, int j, String dir, int[][] visited, ArrayList<ArrayList<Integer>> mat){
        if( i == (mat.size()-1) && j == (mat.size()-1) ){
                list.add(new String(dir));
                return;
            }
        
        for(int k=0;k<4;k++){
            int nexti = (i+dirX[k]);
            int nextj = (j+dirY[k]);
            if( nexti>=0 &&
                nextj>=0 && 
                nexti < mat.size() &&
                nextj < mat.size() &&
                mat.get(nexti).get(nextj) == 1 &&
                visited[nexti][nextj] == 0) {
                    visited[nexti][nextj] = 1;
                    solve(nexti,nextj,new String(dir+dirPos[k]),visited,mat);
                    visited[nexti][nextj] = 0;
                }
        }
    }
    
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        list = new ArrayList<>();
        int[][] visited = new int[mat.size()][mat.size()];
        visited[0][0] = 1;
        solve(0,0,"",visited, mat);
        return list;
    }
}

TC: O(4^(N*M))
SC: O(N*M) 
