import java.util.*;

class Solution {
    private int[][] dp;
    private int alpMax,copMax;

    public int solution(int alp, int cop, int[][] problems) {
        for(int[] p : problems){
            int alpReq = p[0];
            int copReq = p[1];
            int alpRwd = p[2];
            int copRwd = p[3];
            int cost = p[4];
            alpMax = Math.max(alpMax,alpReq);
            copMax = Math.max(copMax,copReq);
        }
        if(alp >= alpMax && cop >= copMax) return 0;
        alpMax = Math.max(alpMax,alp);
        copMax = Math.max(copMax,cop);
        dp = new int[alpMax+2][copMax+2];
        
        for(int i=alp;i<=alpMax;i++){
            for(int j=cop;j<=copMax;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        for(int i=alp;i<=alpMax;i++){
            for(int j=cop;j<=copMax;j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                
                for(int[] p : problems){
                    int alpReq = p[0];
                    int copReq = p[1];
                    int alpRwd = p[2];
                    int copRwd = p[3];
                    int cost = p[4];
                    if(i < alpReq || j < copReq) continue;
                    int alpTarget = i+alpRwd >= alpMax ? alpMax : i+alpRwd;
                    int copTarget = j+copRwd >= copMax ? copMax : j+copRwd;
                    if(dp[i][j] + cost < dp[alpTarget][copTarget]){
                        dp[alpTarget][copTarget] = dp[i][j] + cost;
                    }
                }
            }
        }
        
        return dp[alpMax][copMax];
        
    }
}