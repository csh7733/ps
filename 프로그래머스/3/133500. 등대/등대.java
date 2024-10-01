import java.util.*;

class Solution {
    List<List<Integer>> edge = new ArrayList<>();
    boolean[] visit;
    int root;
    int answer;
    
    private int dfs(int cur){
        visit[cur] = true;
        
        if(edge.get(cur).size() == 1 && cur != root){
            return 1;
        }
        
        int total = 0;
        for(int i=0;i<edge.get(cur).size();i++){
            int next = edge.get(cur).get(i);
            if(visit[next]) continue;
            total += dfs(next);
        }
        
        if(total > 0){
            answer++;
            return 0;
        }
        
        return 1;
    }
    
    public int solution(int n, int[][] lighthouse) {
        visit = new boolean[n+1];
        for(int i=0;i<=n;i++){
            edge.add(new ArrayList<>());
        }
        for(int[] l : lighthouse){
            int src = l[0];
            int dest = l[1];
            edge.get(src).add(dest);
            edge.get(dest).add(src);
        }
        root = 1;
        dfs(1);
        return answer;
    }
}