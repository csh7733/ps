import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int length = targets.length;
        Arrays.sort(targets, Comparator.comparingInt(t -> t[1]));
        int cur = 0;
        int answer = 0;
        for(int i=0;i<length;i++){
            if(targets[i][0] >= cur){
                answer++;
                cur = targets[i][1];
            }
        }
        return answer;
    }
}