import java.util.*;

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int[][] m;
    int[][] dist;
    int N,M;
    
    private int bfs(int sx,int sy,int fx,int fy){
        Queue<int[]> q = new LinkedList<>();
        dist[sx][sy] = 1;
        q.offer(new int[]{sx,sy});
        while(!q.isEmpty()){
            int[] front = q.poll();
            int x = front[0];
            int y = front[1];
            if(x == fx && y == fy) return dist[x][y]-1;
            for(int k=0;k<4;k++){
                int nx = x, ny = y;
                while(true){
                    nx += dx[k];
                    ny += dy[k];
                    if(nx<0 || nx>=N || ny<0 || ny>= M) {
                        nx -= dx[k];
                        ny -= dy[k];
                        break;
                    }
                    if(m[nx][ny] == -1) {
                        nx -= dx[k];
                        ny -= dy[k];
                        break;
                    }
                }
                if(dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        m = new int[N][M];
        dist = new int[N][M];
        int sx = 0,sy = 0,fx = 0,fy = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i].charAt(j) == 'R'){
                    sx = i;
                    sy = j;
                }else if(board[i].charAt(j) == 'D'){
                    m[i][j] = -1;
                }else if(board[i].charAt(j) == 'G'){
                    fx = i;
                    fy = j;
                }
            }
        }
        return bfs(sx,sy,fx,fy);
    }
}