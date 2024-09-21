import java.util.*;

class Solution {
    private int[][] graph;
    private int[] dist;
    private boolean[] visit;

    private void dijkstra(int N,int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[1]-o2[1];
        });
        dist[start] = 0;
        pq.offer(new int[]{start,dist[start]});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if(visit[curNode]) continue;
            visit[curNode] = true;

            for(int i=1;i<=N;i++){
                if(graph[curNode][i] == Integer.MAX_VALUE) continue;
                if(curDist+graph[curNode][i] < dist[i]){
                    dist[i] = curDist+graph[curNode][i];
                    pq.offer(new int[]{i,dist[i]});
                }
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        graph = new int[N+1][N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int[] r : road){
            int node1 = r[0];
            int node2 = r[1];
            int w = r[2];
            if(w < graph[node1][node2]){
                graph[node1][node2] = w;
                graph[node2][node1] = w;
            }
        }
        dijkstra(N,1);
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}