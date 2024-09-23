import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> total = new HashMap<>();
        Map<String,ArrayList<int[]>> components = new HashMap<>();
        for(int i=0;i< genres.length;i++){
            total.put(genres[i],total.getOrDefault(genres[i],0) + plays[i]);
            ArrayList<int[]> component = components.computeIfAbsent(genres[i], key -> new ArrayList<>());
            component.add(new int[]{i,plays[i]});
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(total.entrySet());
        entries.sort((o1, o2) -> {
            return o2.getValue()-o1.getValue();
        });
        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            ArrayList<int[]> component = components.get(key);
            component.sort((o1, o2) -> {
                return o2[1]-o1[1];
            });
            answer.add(component.get(0)[0]);
            if(component.size() >= 2){
                answer.add(component.get(1)[0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}