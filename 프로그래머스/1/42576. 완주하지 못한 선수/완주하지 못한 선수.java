import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> m = new HashMap<>();
        for(String part : participant){
            m.put(part,m.getOrDefault(part,0) + 1);
        }
        for(String comp : completion){
            int remain = m.get(comp) - 1;
            if(remain == 0) m.remove(comp);
            else m.put(comp,remain);
        }
        String answer = "";
        for(String key : m.keySet()){
            answer = key;
        }
        return answer;
    }
}