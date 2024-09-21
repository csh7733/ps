import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private int[] dist;

    private void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            int curDist = dist[cur];
            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                if(dist[next] != -1) continue;
                dist[next] = curDist + 1;
                q.add(next);
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new List[n+1];
        dist = new int[n+1];
        for(int i=1;i<=n;i++) {
            dist[i] = -1;
        }
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int node1 = road[0];
            int node2 = road[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        bfs(destination);
        ArrayList<Integer> result = new ArrayList<>();
        for(int source : sources){
            result.add(dist[source]);
        }
        int[] ret = new int[result.size()];
        for(int i =0;i<ret.length;i++){
            ret[i] = result.get(i);
        }

        return ret;
    }

}