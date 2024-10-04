class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visit = new boolean[5][5];
    static int N,M;
    
    static int dfs(int x1,int y1,int x2,int y2,int[][] board){
        if(visit[x1][y1]) return 0;
        
        int result = 0;
        for(int k=0;k<4;k++){
            int nx = x1 + dx[k],ny = y1 + dy[k];
            if(nx<0 || nx>= N || ny<0 || ny>=M) continue;
            if(board[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;
            visit[x1][y1] = true;
            int cur = dfs(x2,y2,nx,ny,board) + 1;
            visit[x1][y1] = false;
            if(result % 2 == 0 && cur % 2 == 1) result = cur;
            else if(result % 2 == 0 && cur % 2 == 0) result = Math.max(result,cur);
            else if(result % 2 == 1 && cur % 2 == 1) result = Math.min(result,cur);
        }
        
        return result;
    }
    
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1],board);
    }
}