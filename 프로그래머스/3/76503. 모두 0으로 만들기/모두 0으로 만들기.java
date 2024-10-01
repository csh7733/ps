import java.util.*;

class Solution {
    private static List<List<Integer>> edge = new ArrayList<>();
    private static boolean[] visit;
    private static int root;
    private static long answer;
    
    private static long dfs(int cur,int[] a){
        visit[cur] = true;
        if(edge.get(cur).size() == 1 && cur != root){
            answer += Math.abs(a[cur]);
            return a[cur];
        }
        
        long total = 0;
        for(int i=0;i<edge.get(cur).size();i++){
            int next = edge.get(cur).get(i);
            if(visit[next]) continue;
            total += dfs(next,a);
        }
        total += a[cur];

        answer += Math.abs(total);   
    
        return total;
    }
    
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        if(sum != 0) return -1;
        
        visit = new boolean[a.length];
        for(int i=0;i<a.length;i++){
            edge.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int src = e[0];
            int dest = e[1];
            edge.get(src).add(dest);
            edge.get(dest).add(src);
        }
        root = 0;
        dfs(root,a);
        
        return answer;
    }
}