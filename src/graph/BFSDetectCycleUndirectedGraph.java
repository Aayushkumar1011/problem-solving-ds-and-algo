/**
  Problem statement
  https://www.interviewbit.com/problems/cycle-in-undirected-graph/
*/

public class BFSDetectCycleUndirectedGraph {
    class PairVertex{
        int first;
        int second;
        public PairVertex(int _first, int _second){
            this.first = _first;
            this.second = _second;
        }
    }
    
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
                if(checkCycle(i, adj, visited)){
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    private boolean checkCycle(int sourceVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<PairVertex> q = new LinkedList<>();
        visited[sourceVertex] = true;
        q.offer(new PairVertex(sourceVertex, -1));
        
        while(!q.isEmpty()){
            int currentVertex = q.peek().first;
            int parentVertex = q.peek().second;
            q.poll();
            for(Integer ver: adj.get(currentVertex)){
                if(!visited[ver]){
                    visited[ver] = true;
                    q.offer(new PairVertex(ver, currentVertex));
                }
                else if(ver != parentVertex){
                    return true;
                }
            }
            
        }
        return false;
    }
}
