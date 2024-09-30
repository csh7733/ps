class Solution {
    private int[][] m;
    private int N,M;
    private int answer = Integer.MAX_VALUE;
    
    private void reverse(int i){
        for(int j=0;j<M;j++){
            m[i][j] = 1 - m[i][j];
        }
    }
    
    private void check(int cnt, int[][] target){
        int w = 0;
        for(int j=0;j<M;j++){
            int diff = 0;
            for(int i=0;i<N;i++){
                if(m[i][j] != target[i][j]) diff++;
            }
            if(diff != 0 && diff != N) return;
            if(diff == N) w++;
        }
        answer = Math.min(answer,cnt+w);
    }
    
    private void select(int index,int cnt, int[][] target){
        if(index == N){
            check(cnt,target);
            return;
        }
        select(index+1,cnt,target);
        reverse(index);
        select(index+1,cnt+1,target);
        reverse(index);
    }
    
    public int solution(int[][] beginning, int[][] target) {
        N = beginning.length;
        M = beginning[0].length;
        m = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                m[i][j] = beginning[i][j];
            }
        }
        select(0,0,target);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}