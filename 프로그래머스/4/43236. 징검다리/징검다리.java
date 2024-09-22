import java.util.*;

class Solution {

    private boolean isValid(int mid, int distance, int[] rocks, int n){
        int before = 0;
        int end = distance;
        int cnt = 0;
        for(int rock : rocks){
            if(rock-before < mid){
                cnt++;
            }else{
                before = rock;
            }
        }
        if(end-before < mid) cnt++;
        return cnt<=n;
    }

    private int search(int distance, int[] rocks, int n){
        int left = 1;
        int right = distance;
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(isValid(mid,distance,rocks,n)){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return search(distance,rocks,n);
    }
}