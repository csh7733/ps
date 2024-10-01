import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] p1 = new int[10001];
        int[] p2 = new int[10001];
        int cnt1 = 0,cnt2 = 0;
        int answer = 0;
        for(int t : topping){
            if(p1[t] == 0) cnt1++;
            p1[t]++;
        }
        for(int t : topping){
            if(p2[t] == 0) cnt2++;
            p2[t]++;
            if(p1[t]-1 == 0) cnt1--;
            p1[t]--;
            if(cnt1 == cnt2) answer++;
        }
        return answer;
    }
}