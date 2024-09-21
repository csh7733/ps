import java.util.*;

class Solution {
    private List<int[]>[] graph;
    private Set<Integer> gateSet;
    private Set<Integer> summitSet;

    private int[] dijkstra(int n){
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[1] == o2[1]){
                return o1[0]-o2[0];
            }else{
                return o1[1]-o2[1];
            }
        });
        for(Integer gate : gateSet){
            dist[gate] = 0;
            pq.offer(new int[]{gate,dist[gate]});
        }
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int cur = front[0];
            int curDist = front[1];

            if(visit[cur]) continue;
            visit[cur] = true;

            if(summitSet.contains(cur)) {
                result.add(new int[]{cur,curDist});
                continue;
            }

            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i)[0];
                int w = graph[cur].get(i)[1];
//                if(gateSet.contains(next)) continue;
                if(dist[next] > Math.max(curDist,w)){
                    dist[next] = Math.max(curDist,w);
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int[] ret = new int[2];
        Arrays.fill(ret,Integer.MAX_VALUE);
        for(int i=0;i<result.size();i++){
            int i0 = result.get(i)[0];
            int i1 = result.get(i)[1];
            if(ret[1] > i1){
                ret[0] = i0;
                ret[1] = i1;
            }else if(ret[1] == i1){
                ret[0] = Math.min(ret[0],i0);
            }
        }
        return ret;
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new List[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            int src = path[0];
            int dest = path[1];
            int w = path[2];
            graph[src].add(new int[]{dest,w});
            graph[dest].add(new int[]{src,w});
        }
        gateSet = new HashSet<>();
        for(Integer gate : gates){
            gateSet.add(gate);
        }
        summitSet = new HashSet<>();
        for(Integer summit : summits){
            summitSet.add(summit);
        }
        return dijkstra(n);
    }
}