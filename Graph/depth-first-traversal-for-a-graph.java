class Solution {
    private void dfs(int node, ArrayList<Integer> DFS, ArrayList<ArrayList<Integer>> adj,
    boolean[] vis) {
        vis[node] = true;
        DFS.add(node);
        
        for(Integer it : adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, DFS, adj, vis);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> DFS = new ArrayList<>();
        dfs(0, DFS, adj, vis);
        return DFS;
    }
}
