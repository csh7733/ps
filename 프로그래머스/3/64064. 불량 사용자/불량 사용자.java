class Solution {
    int N,M;
    boolean[] result;
    boolean[][] can;
    boolean[] visit = new boolean[8];

    private void solve(int cnt,int check){
        if(cnt == M){
            result[check] = true;
            return;
        }
        for(int i=0;i<N;i++){
            if(visit[i]) continue;
            if(!can[i][cnt]) continue;
            visit[i] = true;
            solve(cnt+1,check | (1<<i));
            visit[i] = false;
        }
    }
    
    private boolean canConvert(String[] user_id, String[] banned_id,int i,int j){
        String first = user_id[i];
        String second = banned_id[j];
        if(first.length() != second.length()) return false;
        for(int k=0;k<first.length();k++){
            if(first.charAt(k) != second.charAt(k) && second.charAt(k) != '*') return false;
        }
        return true;
    }
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        result = new boolean[1<<N];
        can = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(canConvert(user_id,banned_id,i,j)) can[i][j] = true;
                else can[i][j] = false;
            }
        }
        solve(0,0);
        int answer = 0;
        for(int i=0;i<(1<<N);i++){
            if(result[i]) answer++;
        }
        return answer;
    }
}