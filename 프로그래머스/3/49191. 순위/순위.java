import java.util.*;

class Solution {
    int[][] check;
    boolean[] visit;

    private int getCntAndReset(int n){
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(visit[i]) cnt++; 
        }
        Arrays.fill(visit,false);
        return cnt-1;
    }
    
    private void dfs(int n,int cur,int state){
        visit[cur] = true;
        for(int i=1;i<=n;i++){
            if(check[cur][i] == state && !visit[i]){
                dfs(n,i,state);
            }
        }
    }
    public int solution(int n, int[][] results) {
        check = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int[] result : results){
            int f = result[0];
            int s = result[1];
            check[f][s] = 1;
            check[s][f] = -1;
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            dfs(n,i,1);
            int cnt1 = getCntAndReset(n);
            dfs(n,i,-1);
            int cnt2 = getCntAndReset(n);
            if(cnt1 + cnt2 == n-1) answer++;
        }
        return answer;
    }
}