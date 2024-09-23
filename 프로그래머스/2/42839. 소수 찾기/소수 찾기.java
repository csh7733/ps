import java.util.*;
class Solution {

    private int[] cnt = new int[10];
    private boolean[] notPrime = new boolean[10000000];

    private boolean canMake(int n){
        int[] temp = Arrays.copyOf(cnt, cnt.length);
        while(n>0){
            int last = n % 10;
            if(temp[last] == 0) return false;
            temp[last]--;
            n /= 10;
        }
        return true;
    }

    public int solution(String numbers) {
        for(int i=2;i<10000;i++){
            if(notPrime[i]) continue;
            for(int j=i*i;j<10000000;j+=i){
                notPrime[j] = true;
            }
        }

        for(int i=0;i<numbers.length();i++){
            int number = Integer.parseInt(numbers.substring(i, i + 1));
            cnt[number]++;
        }

        int answer = 0;
        for(int i=2;i<10000000;i++){
            if(canMake(i) && !notPrime[i]){
                answer++;
            }
        }

        return answer;

    }
}
