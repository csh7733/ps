import java.util.*;

class Solution {

    private Boolean check(StringBuilder sb){
        String s = sb.toString();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(1);
            }
            if(s.charAt(i) == '{'){
                stack.push(2);
            }
            if(s.charAt(i) == '['){
                stack.push(3);
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != 1) return false;
                stack.pop();
            }
            if(s.charAt(i) == '}'){
                if(stack.isEmpty() || stack.peek() != 2) return false;
                stack.pop();
            }
            if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != 3) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int answer = 0;
        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            if(check(sb)) answer++;
        }
        return answer;
    }
}