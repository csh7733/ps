import java.util.*;

class Solution {
    private Map<String,Integer> have = new HashMap<>();
    private int total;
    private int cur;
    private int answer1,answer2,answerLen = Integer.MAX_VALUE;
    public int[] solution(String[] gems) {
        for(String gem : gems){
            have.put(gem,1);
        }
        total = have.size();
        have.clear();

        int left = 0,right = 0;
        have.put(gems[0],1);
        cur = 1;
        while(right<gems.length){
            if(cur < total){
                right++;
                if(right < gems.length && !have.containsKey(gems[right])){
                    cur++;
                }
                if(right < gems.length) have.put(gems[right],have.getOrDefault(gems[right],0) + 1);
            }else{
                if(right-left+1 < answerLen){
                    answer1 = left;
                    answer2 = right;
                    answerLen = right-left+1;
                }
                have.put(gems[left],have.get(gems[left]) - 1);
                if(have.get(gems[left]) == 0) {
                    have.remove(gems[left]);
                    cur--;
                }
                left++;
            }
        }
        return new int[]{answer1+1,answer2+1};
    }
}