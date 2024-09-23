import java.util.*;

class Solution {

    private PriorityQueue<int[]> pq;
    private int before = -1;

    private void searchAndInsert(int[][] jobs,int time){
        int left = 0;
        int right = jobs.length-1;
        int find = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(jobs[mid][0] > time){
                right = mid -1;
            }else{
                find = mid;
                left = mid+1;
            }
        }
        if(find == 0 && jobs[find][0] > time) return;
        for(int i=before+1;i<=find;i++){
            pq.offer(jobs[i]);
        }
        before = find;
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        pq = new PriorityQueue<>((o1,o2)->{
            return o1[1]-o2[1];
        });
        int time = 0;
        int total = 0;
        while(true){
            searchAndInsert(jobs,time);
            if(pq.isEmpty()){
                if(before == jobs.length-1) break;
                else{
                    pq.offer(jobs[++before]);
                    time = jobs[before][0];
                }
            }
            int[] poll = pq.poll();
            time += poll[1];
            total += (time-poll[0]);
        }
        return total/jobs.length;
    }
}