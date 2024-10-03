import java.util.*;

class Solution {
    static int N,M;
    static int[][] m;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static int dfs(int x,int y){
        visit[x][y] = true;
        int total = m[x][y];
        for(int k=0;k<4;k++){
            int nx = x + dx[k],ny = y + dy[k];
            if(nx<0 || nx>=N || ny <0 || ny>=M) continue;
            if(m[nx][ny] == -1) continue;
            if(visit[nx][ny]) continue;
            total += dfs(nx,ny);
        }
        
        return total;
    }
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        m = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i].charAt(j) == 'X') m[i][j] = -1;
                else m[i][j] = maps[i].charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j] && m[i][j] != -1){
                    int cur = dfs(i,j);
                    answer.add(cur);
                }
            }
        }
        if(answer.isEmpty()) return new int[]{-1};
        answer.sort((o1,o2)->{
            return o1-o2;
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}