class Solution {
    private int[][] edge;
    private boolean[] visit;

    private void dfs(int x,int n){
        visit[x] = true;
        for(int i=0;i<n;i++){
            if(i == x) continue;
            if(edge[x][i] == 1 && !visit[i]){
                dfs(i,n);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        edge = computers;
        visit = new boolean[n];
        int answer = 0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i,n);
                answer++;
            }
        }
        return answer;
    }
}