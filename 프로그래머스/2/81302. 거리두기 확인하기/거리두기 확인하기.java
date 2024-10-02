import java.util.*;

class Solution {
    static char[][] m = new char[5][5];
    static int[][] dist = new int[5][5];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    private static boolean bfs(int sx,int sy){
        dist[sx][sy] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0], y = poll[1];
            if(dist[x][y] == 2) return true;
            for(int k=0;k<4;k++){
                int nx = x + dx[k], ny = y + dy[k];
                if(nx<0 || nx>= 5 || ny<0 || ny>=5) continue;
                if(dist[nx][ny] != -1) continue;
                if(m[nx][ny] == 'X') continue;
                if(m[nx][ny] == 'P') return false;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int cnt=0;cnt<5;cnt++){
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    m[i][j] = places[cnt][i].charAt(j);
                    dist[i][j] = -1;
                }
            }
            boolean escape = false;
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(m[i][j] == 'P'){
                        if(!bfs(i,j)){
                            escape = true;
                            answer[cnt] = 0;
                        }
                    }
                    if(escape) continue;
                }
            }
            if(!escape) answer[cnt] = 1;
        }
        return answer;
    }
}