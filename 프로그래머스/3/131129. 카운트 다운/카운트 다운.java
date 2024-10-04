import java.util.*;

class Solution {
    static int[] dp = new int[100001];
    static int[] dp2 = new int[100001];
    
    public int[] solution(int target) {
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<=100000;i++){
            int offset = 50;
            int next = i+offset >= 100000 ? 100000 : i +offset;
            if(dp[i] + 1 < dp[next]){
                dp[next] = dp[i] + 1;
                dp2[next] = dp2[i] + 1;
            }else if(dp[i] + 1 == dp[next]){
                dp2[next] = Math.max(dp2[next],dp2[i]+1);
            }
            for(int j=1;j<=20;j++){
                offset = j;
                next = i+offset >= 100000 ? 100000 : i +offset;
                if(dp[i] + 1 < dp[next]){
                    dp[next] = dp[i] + 1;
                    dp2[next] = dp2[i] + 1;
                }else if(dp[i] + 1 == dp[next]){
                    dp2[next] = Math.max(dp2[next],dp2[i]+1);
                }
            }
            for(int j=2;j<=40;j+=2){
                offset = j;
                next = i+offset >= 100000 ? 100000 : i +offset;
                if(dp[i] + 1 < dp[next]){
                    dp[next] = dp[i] + 1;
                    dp2[next] = dp2[i];
                }else if(dp[i] + 1 == dp[next]){
                    dp2[next] = Math.max(dp2[next],dp2[i]);
                }
            }
            for(int j=3;j<=60;j+=3){
                offset = j;
                next = i+offset >= 100000 ? 100000 : i +offset;
                if(dp[i] + 1 < dp[next]){
                    dp[next] = dp[i] + 1;
                    dp2[next] = dp2[i];
                }else if(dp[i] + 1 == dp[next]){
                    dp2[next] = Math.max(dp2[next],dp2[i]);
                }
            }
        }
        return new int[]{dp[target],dp2[target]};
    }
}