class Solution {
    private void dfs(int r, int c, int[][] image, int oldColor, int color) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor || image[r][c] == color) {
            return;
        }

        image[r][c] = color;

        dfs(r, c+1, image, oldColor, color);
        dfs(r+1, c, image, oldColor, color);
        dfs(r, c-1, image, oldColor, color);
        dfs(r-1, c, image, oldColor, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length == 1 && image[0].length == 1) {
            image[0][0] = color;
            return image;
        }
        int oldColor = image[sr][sc];
        dfs(sr, sc, image, oldColor, color);
        return image;
    }
}
