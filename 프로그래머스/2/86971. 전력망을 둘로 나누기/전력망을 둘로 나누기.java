import java.util.*;

class Solution {
    private int[][] edge;
    private boolean[] visit;
    
    private void dfs(int cur,int n, int[][] wires){
        visit[cur] = true;
        for(int i=1;i<=n;i++){
            if(edge[cur][i] == 1 && !visit[i]) dfs(i,n,wires);
        }
    }
    
    public int solution(int n, int[][] wires) {
        edge = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int[] wire : wires){
            int src = wire[0];
            int dest = wire[1];
            edge[src][dest] = 1;
            edge[dest][src] = 1;
        }
        int answer = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int src = wire[0];
            int dest = wire[1];
            edge[src][dest] = 0;
            Arrays.fill(visit,false);
            dfs(src,n,wires);
            int cnt = 0;
            for(int i=1;i<=n;i++){
                if(visit[i]) cnt++;
            }
            answer = Math.min(answer,Math.abs(n-2*cnt));
            edge[src][dest] = 1;
        }
        return answer;
    }
}