public class DFSDetectCycleInUndirectedGraph {
    
    public int solve(int V, ArrayList<ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[V+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= V; i++){
            adj.add(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.size(); i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                if(checkCycleDFS(i, -1, adj, visited)){
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    private boolean checkCycleDFS(int sourceVertex, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[sourceVertex] = true;
        for(Integer ver: adj.get(sourceVertex)){
            if(!visited[ver]){
                if(checkCycleDFS(ver, sourceVertex, adj, visited))
                    return true;
                }
                else if(ver != parent)
                    return true;
        }
        return false;
    }
}
