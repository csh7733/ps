import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(((o1, o2) -> {
            return o2-o1;
        }));
        Map<Integer,Boolean> m = new HashMap<>();
        for(String operation : operations){
            String[] split = operation.split(" ");
            String cmd = split[0];
            Integer target = Integer.parseInt(split[1]);
            if(cmd.equals("I")){
                pqMin.offer(target);
                pqMax.offer(target);
                m.put(target,true);
            }else{
                if(target == 1 && !pqMax.isEmpty()){
                    Integer poll = pqMax.poll();
                    while(!m.get(poll) && !pqMax.isEmpty()){
                        poll = pqMax.poll();
                    }
                    m.put(poll,false);
                }else if(target == -1 && !pqMin.isEmpty()){
                    Integer poll = pqMin.poll();
                    while(!m.get(poll) && !pqMin.isEmpty()){
                        poll = pqMin.poll();
                    }
                    m.put(poll,false);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;
        for(Integer key : m.keySet()){
            if(m.get(key)){
                answer[0] = Math.max(answer[0],key);
                answer[1] = Math.min(answer[1],key);
            }
        }
        if(answer[0] == Integer.MIN_VALUE && answer[1] == Integer.MAX_VALUE){
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}