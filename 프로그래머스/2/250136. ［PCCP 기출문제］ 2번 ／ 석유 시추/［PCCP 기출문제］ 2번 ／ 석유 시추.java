
import java.util.*;

class Solution {
    static boolean[][] visit;
    static int N,M;
    static int[][] land2;
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};
    static List<Integer> cnt = new ArrayList<>();

    private static void bfs(int sx,int sy,int[][] land,int idx){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visit[sx][sy] = true;
        int size = 1;
        land2[sx][sy] = idx;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int k=0;k<4;k++){
                int nx = x +dx[k],ny = y +dy[k];
                if(nx<0 || nx>=N || ny <0 || ny >=M) continue;
                if(!visit[nx][ny] && land[nx][ny] == 1){
                    size++;
                    visit[nx][ny] = true;
                    land2[nx][ny] = idx;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        cnt.add(size);
    }
    
    private static int solve(int y,int[][] land){
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<N;i++){
            s.add(land2[i][y]);
        }
        int total = 0;
        for(Integer num : s){
            if(num != 0) total += cnt.get(num-1);
        }
        return total;
    }

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visit = new boolean[N][M];
        land2 = new int[N][M];
        int idx = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j] && land[i][j] == 1) bfs(i,j,land,idx++);
            }
        }
        int answer = 0;
        for(int j=0;j<M;j++){
            answer = Math.max(answer,solve(j,land));
        }
        return answer;
    }
}