import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((p1,p2)->p2[0]-p1[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((p1,p2)->p2[0]-p1[0]);
        for(int i=0;i<n;i++) {
            if(deliveries[i] != 0) pq1.offer(new int[]{i + 1, deliveries[i]});
            if(pickups[i] != 0) pq2.offer(new int[]{i + 1, pickups[i]});
        }
        long distance = 0;
        while(!pq1.isEmpty() || !pq2.isEmpty()){
            int go = !pq1.isEmpty() ? pq1.peek()[0] : 0;
            int back = !pq2.isEmpty() ? pq2.peek()[0] : 0;
            int curDistance = Math.max(go,back);
            distance += curDistance*2L;
            int remain = cap;
            while(!pq1.isEmpty() && remain > 0){
                int[] cur = pq1.poll();
                if(cur[1] > remain){
                    pq1.offer(new int[]{cur[0],cur[1]-remain});
                    remain = 0;
                }else{
                    remain -= cur[1];
                }
            }
            remain = cap;
            while(!pq2.isEmpty() && remain > 0){
                int[] cur = pq2.poll();
                if(cur[1] > remain){
                    pq2.offer(new int[]{cur[0],cur[1]-remain});
                    remain = 0;
                }else{
                    remain -= cur[1];
                }
            }
        }

        return distance;
    }
}