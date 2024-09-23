import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        int cnt = 0;
        while(pq.size() >= 2 && pq.peek() < K){
            Integer poll1 = pq.poll();
            Integer poll2 = pq.poll();
            Integer newScovile = poll1 + (poll2*2);
            pq.offer(newScovile);
            cnt++;
        }
        if(pq.peek() >= K) return cnt;
        else return -1;
    }
}