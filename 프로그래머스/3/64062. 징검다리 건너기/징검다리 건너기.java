class Solution {

    private boolean isValid(int mid,int[] stones,int k){
        int cnt = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i] < mid){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt >= k) return false;
        }
        return true;
    }
    private int search(int start,int end,int[] stones,int k){
        int left = start,right = end;
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(isValid(mid,stones,k)){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
    public int solution(int[] stones, int k) {
        int max = 0;
        for(int stone : stones){
            max = Math.max(max,stone);
        }
        return search(1, max, stones, k);
    }
}