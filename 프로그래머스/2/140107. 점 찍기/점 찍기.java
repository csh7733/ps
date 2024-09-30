class Solution {
    //j^2 <= d^2 - i^2
    public long solution(int k, int d) {
        long cnt = 0;
        for(int i=0;i<=d;i+=k){
            int j = (int)Math.pow(Math.pow(d,2) - Math.pow(i,2),0.5);
            cnt += (j/k)+1;
        }
        return cnt;
    }
}