import java.util.*;

class Solution {
    private int[] newElements;
    private int len;
    // 7 9 1 1 4 7 9 1 1
    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();
        len = elements.length;
        newElements = new int[2*len-1];
        for(int i=0;i<len;i++){
            newElements[i] = elements[i];
        }
        for(int i=0;i<len-1;i++){
            newElements[len+i] = newElements[i];
        }
        int[] sum = new int[newElements.length+1];
        for(int i=1;i<=newElements.length;i++){
            sum[i] = sum[i-1] + newElements[i-1];
        }
        for(int i=0;i<newElements.length;i++){
            for(int j=0;j<len;j++){
                if(i+j<newElements.length){
                    int curSum = sum[i+j+1]-sum[i];
                    s.add(curSum);
                }
            }
        }
        return s.size();
    }
}