class Solution {
    private int[] numbers;
    private char[] op;
    int N;
    private int[][][] dp;

    private void add(int len,int i,int j){
        if(op[i+j-1] == '+'){
            dp[i][i+len-1][0] = Math.min(dp[i][i+len-1][0],dp[i][i+j-1][0] + dp[i+j][i+len-1][0]);
            dp[i][i+len-1][1] = Math.max(dp[i][i+len-1][1],dp[i][i+j-1][1] + dp[i+j][i+len-1][1]);
        }else{
            dp[i][i+len-1][0] = Math.min(dp[i][i+len-1][0],dp[i][i+j-1][0] - dp[i+j][i+len-1][1]);
            dp[i][i+len-1][1] = Math.max(dp[i][i+len-1][1],dp[i][i+j-1][1] - dp[i+j][i+len-1][0]);
        }
    }

    public int solution(String arr[]) {
        N = arr.length;
        numbers = new int[N/2+1];
        op = new char[N/2];
        for(int i=0;i<N;i++){
            if(i%2 == 0) numbers[i/2] = Integer.parseInt(arr[i]);
            else op[i/2] = arr[i].charAt(0);
        }
        dp = new int[numbers.length][numbers.length][2];
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
        
        for(int i=0;i<numbers.length;i++){
            dp[i][i][0] = numbers[i];
            dp[i][i][1] = numbers[i];
        }
        for(int len = 2;len<=numbers.length;len++){
            for(int i=0;i+len-1<numbers.length;i++){
                for(int j=1;j<len;j++){
                    add(len,i,j);
                }
            }
        }
        return dp[0][numbers.length-1][1];
    }
}