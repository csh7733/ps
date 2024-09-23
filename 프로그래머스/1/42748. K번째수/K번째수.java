import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands){
            int[] newArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(newArray);
            answer.add(newArray[command[2]-1]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}