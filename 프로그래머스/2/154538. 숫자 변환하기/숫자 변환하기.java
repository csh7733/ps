import java.util.*;

class Solution {
    static int dist[] = new int [1000001];
    
    static int bfs(int x,int y,int n){
        dist[x] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == y) return dist[cur]-1;
            int next1 = cur + n;
            if(next1 <= y && dist[next1] == 0){
                dist[next1] = dist[cur] + 1;
                q.offer(next1);
            }
            int next2 = cur*2;
            if(next2 <= y && dist[next2] == 0){
                dist[next2] = dist[cur] + 1;
                q.offer(next2);
            }
            int next3 = cur*3;
            if(next3 <= y && dist[next3] == 0){
                dist[next3] = dist[cur] + 1;
                q.offer(next3);
            }
        }
        return -1;
    }
    
    public int solution(int x, int y, int n) {
        return bfs(x,y,n);
    }
}