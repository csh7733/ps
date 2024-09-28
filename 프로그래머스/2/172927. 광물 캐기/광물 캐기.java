class Solution {
    
    private int[][] w;
    private int result = Integer.MAX_VALUE;
    private int totalPicks;
    
    private void solve(int cnt,int[] picks, String[] minerals,int total){
        if(cnt == totalPicks || cnt == minerals.length/5+1){
            result = Math.min(result,total);
            return;
        }
        
        for(int i=0;i<=2;i++){
            if(picks[i] == 0) continue;
            picks[i]--;
            solve(cnt+1,picks,minerals,total+w[cnt][i]);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int length = minerals.length;
        w = new int[length/5+1][3];
        int cnt = 0;
        int d = 0,ir = 0,s = 0;
        for(int i=0;i<length;i++){
            if(minerals[i].equals("diamond")) d++;
            if(minerals[i].equals("iron")) ir++;
            if(minerals[i].equals("stone")) s++;
            cnt++;
            if(cnt == 5 || i == length-1){
                w[i/5][0] = d+ir+s;
                w[i/5][1] = d*5+ir+s;
                w[i/5][2] = d*25+ir*5+s;
                d = 0;
                ir = 0;
                s = 0;
                cnt = 0;
            }
        }
        for(int pick : picks){
            totalPicks += pick;
        }
        solve(0,picks,minerals,0);
        return result;
    }
}