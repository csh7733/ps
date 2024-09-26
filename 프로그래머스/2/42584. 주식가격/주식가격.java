import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] answer = new int[prices.length];
        for(int i=1;i<prices.length;i++){
            Integer top = s.peek();
            int topPrice = prices[top];
            if(prices[i] >= topPrice){
                s.push(i);
            }else{
                while(true){
                    top = s.peek();
                    answer[top] = i-top;
                    s.pop();
                    if(s.isEmpty() || prices[s.peek()] <= prices[i]){
                        s.push(i);
                        break;
                    }
                }
            }
        }
        while(!s.isEmpty()){
            Integer top = s.pop();
            answer[top] = prices.length - top - 1;
        }
        return answer;
    }
}