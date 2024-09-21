import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> idxs = new Stack<>();
        int[] result = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(idxs.isEmpty()) idxs.push(i);
            else{
                while(true){
                    Integer idx = idxs.peek();
                    int number = numbers[idx];
                    if(numbers[i] > number){
                        result[idx] = numbers[i];
                        idxs.pop();
                        if(idxs.isEmpty()){
                            idxs.push(i);
                            break;
                        }
                    }else{
                        idxs.push(i);
                        break;
                    }
                }
            }
        }
        for(int i=0;i<result.length;i++){
            if(result[i] == 0) result[i] = -1;
        }
        return result;
    }
}