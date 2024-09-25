class Solution {
    private void dfs(int i, int j, int n, String path, ArrayList<String> res,
    int[][] mat) {
        if(i == n-1 && j == n-1) {
            res.add(path);
            return;
        }
        
        if(i < 0 || i >= n || j < 0 || j >= n || mat[i][j] == 0) {
            return;
        }
        
        mat[i][j] = 0;
        dfs(i+1, j, n, path + 'D', res, mat);
        dfs(i, j-1, n, path + 'L', res, mat);
        dfs(i-1, j, n, path + 'U', res, mat);
        dfs(i, j+1, n, path + 'R', res, mat);
        mat[i][j] = 1;
    }
    
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> res = new ArrayList<>();
        if(mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            return res;
        }
        
        dfs(0, 0, n, "", res, mat);
        return res;
    }
}
