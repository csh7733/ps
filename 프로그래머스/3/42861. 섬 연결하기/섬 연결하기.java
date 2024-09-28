import java.util.*;

class Solution {
    int[] parent;
    private int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[y] = x;
    }
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        Arrays.sort(costs,(o1, o2) -> {
            return o1[2]-o2[2];
        });
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int answer = 0;
        for(int[] cost : costs){
            int src = cost[0];
            int dest = cost[1];
            if(find(src) != find(dest)){
                union(src,dest);
                answer += cost[2];
            }
        }
        return answer;
    }
}