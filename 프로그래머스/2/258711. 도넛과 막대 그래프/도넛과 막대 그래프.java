import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer,ArrayList<Integer>> nodes = new HashMap<>();
        int[] result = new int[4];
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            if (!nodes.containsKey(src)) nodes.put(src, new ArrayList<>(List.of(0, 0)));
            if (!nodes.containsKey(dest)) nodes.put(dest, new ArrayList<>(List.of(0, 0)));
            // 0 out 1 in
            Integer srcOut = nodes.get(src).get(0);
            nodes.get(src).set(0, srcOut + 1);
            Integer destIn = nodes.get(dest).get(1);
            nodes.get(dest).set(1, destIn + 1);
        }
        for(Integer key : nodes.keySet()){
            Integer edgeOut = nodes.get(key).get(0);
            Integer edgeIn = nodes.get(key).get(1);
            if(edgeIn == 0 && edgeOut >= 2) {
                result[0] = key;
            }else if(edgeOut == 0) {
                result[2]++;
            }else if(edgeIn >= 2 && edgeOut >=2){
                result[3]++;
            }
        }
        result[1] = nodes.get(result[0]).get(0) - result[2] - result[3];
        return result;
    }
}