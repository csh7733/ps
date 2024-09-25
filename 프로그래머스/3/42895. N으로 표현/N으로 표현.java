import java.util.*;
class Solution {
    Set<Integer>[] dp;
    int answer;

    private void add(int first,int second,int N){
        int make = 0;
        int number = N;
        for(int i=0;i<first+second-1;i++){
            number = 10*number + N;
        }
        dp[first+second].add(number);
        for(Integer f : dp[first]){
            for(Integer s : dp[second]){
                make = f + s;
                dp[first+second].add(make);
                make = f - s;
                dp[first+second].add(make);
                make = f * s;
                dp[first+second].add(make);
                if(s != 0) make = f / s;
                dp[first+second].add(make);
            }
        }
    }
    public int solution(int N, int number) {
        dp = new Set[9];
        for(int i=0;i<=8;i++) {
            dp[i] = new HashSet<>();
        }
        dp[1].add(N);
        if(dp[1].contains(number)) return 1;
        for(int i=2;i<=8;i++){
            for(int j=1;j<i;j++){
                add(j,i-j,N);
                if(dp[i].contains(number)) return i;
            }
        }
        return -1;
    }
}