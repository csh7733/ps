class Solution {
    private int[][] dp;
    private boolean[][] puddle;
    private int R = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        puddle = new boolean[n+1][m+1];
        
        for(int[] p : puddles){
            int x = p[1];
            int y = p[0];
            puddle[x][y] = true;
        }
        
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(!puddle[i-1][j]) dp[i][j] = (dp[i][j] + dp[i-1][j])%R;
                if(!puddle[i][j-1]) dp[i][j] = (dp[i][j] + dp[i][j-1])%R;
            }
        }
        return dp[n][m];
    }
}