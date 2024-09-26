import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int N = progresses.length;
        int[] day = new int[N];
        for(int i=0;i<N;i++){
            int cur = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] != 0) cur++;
            q.offer(cur);
        }
        int front = q.poll(), cnt = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.peek();
            if(now <= front){
                cnt++;
            }else{
                answer.add(cnt);
                front = now;
                cnt = 1;
            }
            q.poll();
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}