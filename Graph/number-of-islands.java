class Node {
    int i;
    int j;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    private void bfs(int i, int j, int m, int n, char[][] grid, boolean[][] vis) {
        Deque<Node> q = new ArrayDeque<>();
        List<Integer> dir = Arrays.asList(0, 1, 0, -1, 0);
        q.offer(new Node(i, j));

        while(q.isEmpty() == false) {
            Node rc = q.poll();
            int r = rc.i;
            int c = rc.j;

            for(int k=0; k < 4; k++) {
                int nr = r + dir.get(k);
                int nc = c + dir.get(k+1);
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false && grid[nr][nc] == '1') {
                    vis[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
    }

    private void dfs(int i, int j, int m, int n, char[][] grid, boolean[][] vis) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || vis[i][j] == true) {
            return;
        }

        vis[i][j] = true;
        dfs(i, j+1, m, n, grid, vis);
        dfs(i+1, j, m, n, grid, vis);
        dfs(i, j-1, m, n, grid, vis);
        dfs(i-1, j, m, n, grid, vis);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 1 && n == 1) {
            return (grid[0][0] == '1') ? 1 : 0;
        }

        int count = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && vis[i][j] == false) {
                    count++;
                    dfs(i, j, m, n, grid, vis);
                    // bfs(i, j, m, n, grid, vis);
                }
            }
        }

        return count;
    }
}
