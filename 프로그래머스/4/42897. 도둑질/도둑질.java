import java.util.*;

class Solution {
    int[] dp0;
    int[] dp1;
    public int solution(int[] money) {
        dp0 = new int[money.length];
        dp1 = new int[money.length];
        int answer = 0;
        dp0[0] = 0;
        dp1[0] = money[0];
        dp0[1] = dp1[0];
        dp1[1] = 0;
        for(int i=2;i<money.length;i++){
            dp0[i] = Math.max(dp0[i-1],dp1[i-1]);
            dp1[i] = dp0[i-1] + money[i];
        }
        answer = dp0[money.length-1];
        Arrays.fill(dp0,0);
        Arrays.fill(dp1,0);
        dp0[0] = 0;
        dp1[0] = 0;
        dp0[1] = 0;
        dp1[1] = money[1];
        for(int i=2;i<money.length;i++){
            dp0[i] = Math.max(dp0[i-1],dp1[i-1]);
            dp1[i] = dp0[i-1] + money[i];
        }
        answer = Math.max(answer,dp0[money.length-1]);
        answer = Math.max(answer,dp1[money.length-1]);
        return answer;
    }
}