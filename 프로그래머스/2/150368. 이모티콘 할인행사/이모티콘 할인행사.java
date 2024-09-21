class Solution {

    private static int[][] users;
    private static int[] emoticons;
    private static int N;
    private static int[] discount;
    private static int answer1;
    private static int answer2;


    private static void cal(){
        int cnt = 0;
        int allTotal = 0;
        for(int[] user : users){
            int allow = user[0];
            int threshold = user[1];
            int total = 0;
            for(int i=0;i<N;i++){
                if(allow <= discount[i]){
                    total += (((100-discount[i])/100.0)*emoticons[i]);
                }
            }
            if(total >= threshold){
                cnt++;
            }else{
                allTotal += total;
            }
        }
        if(cnt > answer1){
            answer1 = cnt;
            answer2 = allTotal;
        }else if(cnt == answer1){
            answer2 = Math.max(answer2,allTotal);
        }

    }

    private static void solve(int cnt) {
        if(cnt == N){
            cal();
            return;
        }
        for(int k=1;k<=4;k++){
            discount[cnt] = k*10;
            solve(cnt+1);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        N = emoticons.length;
        discount = new int[N];
        solve(0);
        return new int[]{answer1,answer2};
    }
}