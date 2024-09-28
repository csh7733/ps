import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(o1,o2)->{
            return o1[1]-o2[1];
        });
        int back = Integer.MAX_VALUE;
        int answer = 0;
        for(int[] route : routes){
            if(route[0] <= back && route[1] >= back) continue;
            answer++;
            back = route[1];
        }
        return answer;
    }
}