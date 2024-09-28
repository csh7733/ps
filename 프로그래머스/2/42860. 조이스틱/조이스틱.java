import java.util.*;

class Solution {
    public int solution(String name) {
        ArrayList<Integer> notA = new ArrayList<>();
        int answer = 0;
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) != 'A') {
                answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
                notA.add(i);
            }
        }
        if(notA.isEmpty()) return 0;
        int minDist = notA.get(notA.size()-1);
        for(int i=0;i<notA.size()-1;i++){
            int front2Back = 2*notA.get(i)+1+(name.length()-1-notA.get(i+1));
            int back2Front = 1+2*(name.length()-1-notA.get(i+1))+1+notA.get(i);
            int curMin = Math.min(front2Back,back2Front);
            minDist = Math.min(minDist,curMin);
        }
        return minDist+answer;
    }
}