import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int size = players.length;
        String[] result = new String[size];
        Map<String,Integer> cur = new HashMap<>();
        for(int i=0;i<size;i++){
            cur.put(players[i],i);
            result[i] = players[i];
        }
        for(String calling : callings){
            int source = cur.get(calling);
            int target = source-1;
            String targetName = result[target];

            result[source] = targetName;
            result[target] = calling;

            cur.put(calling,target);
            cur.put(targetName,source);
        }

        return result;
    }
}
