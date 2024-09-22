import java.util.*;

class Solution {

    private boolean isValid(long mid,int n,int[] times){
        long total = 0;
        for(int time : times){
            total +=  (mid / time);
        }
        return total >= n;
    }

    private long search(int n,int[] times){
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            if(!isValid(mid,n,times)){
                left = mid +1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return search(n, times);
    }
}