class Solution {
    public long solution(int[] sequence) {
        int length = sequence.length;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        long[] dp1 = new long[length];
        long[] dp2 = new long[length];

        for(int i=0;i<length;i++) {
            if (i % 2 == 0) {
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            } else {
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
        }

        dp1[0] = arr1[0];
        dp2[0] = arr2[0];
        long answer = Math.max(dp1[0],dp2[0]);
        for(int i=1;i<length;i++){
            dp1[i] = Math.max(dp1[i-1]+arr1[i],arr1[i]);
            dp2[i] = Math.max(dp2[i-1]+arr2[i],arr2[i]);
            
            answer = Math.max(answer,Math.max(dp1[i],dp2[i]));
        }
        
        return answer;
    }
}