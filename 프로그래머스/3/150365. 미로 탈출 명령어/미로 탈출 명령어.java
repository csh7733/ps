class Solution {
    //dlru
    private final int[] dx = {1,0,0,-1};
    private final int[] dy = {0,-1,1,0};
    private final String[] direction = {"d","l","r","u"};
    private int N,M;
    private int R,C,K;
    private String answer;
    private String cur = "";

    private boolean valid(int x,int y,int cnt){
        int remain = K-cnt;
        int distance = Math.abs(x - R) + Math.abs(y - C);
        return remain-distance >= 0 && (distance-remain) % 2 == 0;
    }

    private void dfs(int x,int y,int cnt){
        if(answer != null) return;
        if(!valid(x,y,cnt)) return;
        if(x == R && y == C && cnt == K){
            answer = cur;
        }else{
            for(int k=0;k<4;k++){
                int nx = x + dx[k], ny = y + dy[k];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                cur += direction[k];
                dfs(nx,ny,cnt+1);
                cur = cur.substring(0,cur.length()-1);
            }
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r-1;
        C = c-1;
        K = k;
        if(!valid(x-1,y-1,0)) return "impossible";
        dfs(x-1,y-1,0);
        return answer;
    }
}