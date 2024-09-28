import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int x = scores[0][0];
        int y = scores[0][1];
        int total = x+y;
        int rank = 1;
        Arrays.sort(scores,(o1,o2)->{
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            else return o2[0]-o1[0];
        });
        int max = 0;
        for(int[] score : scores){
            if(score[1] >= max){
                max = score[1];
                if(score[0]+score[1] > total) rank++;
            }else{
                if(score[0] == x && score[1] == y) return -1;
            }
        }
        
        return rank;
    }
}