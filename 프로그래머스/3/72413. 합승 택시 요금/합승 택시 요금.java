import java.util.*;

class Solution {
    private static int edge[][];
    
    private static int[] dijkstra(int start,int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] visit = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[1]-o2[1];
        });
        dist[start] = 0;
        pq.offer(new int[]{start,dist[start]});
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int cur = poll[0];
            
            if(visit[cur]) continue;
            visit[cur] = true;
            
            for(int i=1;i<=n;i++){
                if(edge[cur][i] == 0) continue;
                if(dist[i] > dist[cur] + edge[cur][i]){
                    dist[i] = dist[cur] + edge[cur][i];
                    pq.offer(new int[]{i,dist[i]});
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        edge = new int[n+1][n+1];
        for(int[] f : fares){
            edge[f[0]][f[1]] = f[2];
            edge[f[1]][f[0]] = f[2];
        }
        
        int[] with = dijkstra(s,n);
        
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int[] alone = dijkstra(i,n);
            
            int cost = with[i] + alone[a] + alone[b];
            answer = Math.min(answer,cost);
        }
        
        return answer;
    }
}