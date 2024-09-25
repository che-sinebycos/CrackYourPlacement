class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        Deque<Integer> qu = new ArrayDeque<>();
        vis[0] = true;
        qu.offer(0);
        
        while(qu.isEmpty() == false) {
            int node = qu.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)) {
                if(vis[it] == false) {
                    qu.offer(it);
                    vis[it] = true;
                }
            }
        }
        
        return bfs;
    }
}
