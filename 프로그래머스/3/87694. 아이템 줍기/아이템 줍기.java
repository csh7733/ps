import java.util.*;
class Solution {

    private int[][] dist;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,1,0,-1};
    private boolean[][] can;

    private int bfs(int sx,int sy,int rx,int ry){
        Queue<int[]> q = new LinkedList<>();
        dist[sx][sy] = 1;
        q.offer(new int[]{sx,sy});
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            if(x == rx && y == ry) return (dist[x][y]-1)/2;
            for(int k=0;k<4;k++){
                int nx = x+dx[k], ny = y+dy[k];
                if(nx<=0 || nx>100 || ny<=0 || ny>100) continue;
                if(dist[nx][ny] != 0) continue;
                if(!can[nx][ny]) continue;;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        return -1;
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        dist = new int[103][103];
        can = new boolean[103][103];
        for(int[] rec : rectangle){
            rec[0] *= 2;
            rec[1] *= 2;
            rec[2] *= 2;
            rec[3] *= 2;
            for(int i = rec[0];i<=rec[2];i++){
                for(int j=rec[1];j<=rec[3];j++){
                    if(i == rec[0] || i == rec[2] || j == rec[1] || j == rec[3]) can[i][j] = true;
                }
            }
        }
        for(int[] rec : rectangle){
            for(int i = rec[0];i<=rec[2];i++){
                for(int j=rec[1];j<=rec[3];j++){
                    if(!(i == rec[0] || i == rec[2] || j == rec[1] || j == rec[3])) can[i][j] = false;
                }
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        return bfs(characterX,characterY,itemX,itemY);
    }
}