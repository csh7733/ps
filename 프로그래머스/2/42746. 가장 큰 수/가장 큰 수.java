import java.util.*;

class Solution {
    String[] array;
    public String solution(int[] numbers) {
        array = new String[numbers.length];
        boolean allZero = true;
        for(int i=0;i<numbers.length;i++){
            array[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) allZero = false;
        }
        if(allZero) return "0";
        Arrays.sort(array,(o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<array.length;i++){
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }
}