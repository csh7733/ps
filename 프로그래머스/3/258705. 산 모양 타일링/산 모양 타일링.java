class Solution {
    int[][] dp;
    public int solution(int n, int[] tops) {
        dp = new int[n+1][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<=n;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4]) % 10007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4]) % 10007;
            dp[i][2] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % 10007;
            if(tops[i-1] == 1) dp[i][3] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % 10007;
            if(tops[i-1] == 1)dp[i][4] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % 10007;
        }
        return (dp[n][0] +dp[n][2] +dp[n][3]) % 10007;
    }
}