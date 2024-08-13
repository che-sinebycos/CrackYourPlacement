class Solution {
    private void swap(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
    }

    private void swap(int[][] matrix, int i, int j, int n) {
        matrix[i][j] = matrix[i][j] ^ matrix[i][n-j-1];
        matrix[i][n-j-1] = matrix[i][j] ^ matrix[i][n-j-1];
        matrix[i][j] = matrix[i][j] ^ matrix[i][n-j-1];
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) {
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                swap(matrix, i, j);
            }
        }

        for(int i=0; i<n; i++) {
            int j = 0;
            while(j < n/2) {
                swap(matrix, i, j, n);
                j++;
            }
        }
    }
}
