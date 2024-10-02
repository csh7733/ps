import java.util.*;

class Solution {
    private static Map<String,ArrayList<Integer>> m = new HashMap<>();
    private static void select(int cnt,String[] split,StringBuilder sb){
        if(cnt == 4){
            m.computeIfAbsent(sb.toString(),key -> new ArrayList<>()).add(Integer.parseInt(split[4]));
                        // System.out.println(sb.toString());
            return;
        }
        sb.append('-');
        select(cnt+1,split,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(split[cnt]);
        select(cnt+1,split,sb);
        sb.setLength(sb.length()-split[cnt].length());
    }
    
    private static int search(ArrayList<Integer> arr , int x){
        int left = 0;
        int right = arr.size()-1;
        int answer = 0;
        if(right == -1) return -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr.get(mid) < x){
                left = mid+1;
            }else{
                answer = mid;
                right = mid-1;
            }
        }
        if(left == arr.size()) return -1;
        return answer;
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String i : info){
            String[] split = i.split(" ");
            StringBuilder sb = new StringBuilder();
            select(0,split,sb);
        }
        for(String key : m.keySet()){
            m.get(key).sort((o1,o2)->{
                return o1-o2;
            });
        }
        int i = 0;
        for(String q : query){
            q = q.replace(" and ", " ");
            String[] split = q.split(" ");
            String key = String.join("",split[0],split[1],split[2],split[3]);
            ArrayList<Integer> arr = m.getOrDefault(key,new ArrayList<>());
            int idx = search(arr,Integer.parseInt(split[4]));
            if(idx == -1) answer[i++] = 0;
            else answer[i++] = arr.size()-idx;
        }
        return answer;
    }
}