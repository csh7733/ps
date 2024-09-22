import java.util.*;

class Solution {
    private int length;
    private int[][] Dice;
    private boolean[] choose;
    private int[] cntA = new int[501];
    private int[] cntB = new int[501];
    private int answer = Integer.MIN_VALUE;
    private int[] result;


    private void calA(int cnt,int total,ArrayList<Integer> target,int size){
        if(cnt == size){
            cntA[total]++;
        }else{
            for(int i=0;i<6;i++){
                int cur = target.get(cnt);
                calA(cnt+1,total+Dice[cur][i],target,size);
            }
        }
    }

    private void calB(int cnt,int total,ArrayList<Integer> target,int size){
        if(cnt == size){
            cntB[total]++;
        }else{
            for(int i=0;i<6;i++){
                int cur = target.get(cnt);
                calB(cnt+1,total+Dice[cur][i],target,size);
            }
        }
    }

    private void simulate(){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Arrays.fill(cntA,0);
        Arrays.fill(cntB,0);

        for(int i=0;i<length;i++){
            if(choose[i]) a.add(i);
            else b.add(i);
        }

        calA(0,0,a,length/2);
        calB(0,0,b,length/2);

        int[] sumCntA = new int[502];
        int[] sumCntB = new int[502];
        for(int i=1;i<=501;i++){
            sumCntA[i] = sumCntA[i-1] + cntA[i-1];
            sumCntB[i] = sumCntB[i-1] + cntB[i-1];
        }
        int totalCnt = 0;
        for(int i=1;i<500;i++){
            totalCnt += cntB[i]*(sumCntA[501]-sumCntA[i+1]);
        }
        if(totalCnt > answer){
            answer = totalCnt;
                result = a.stream().mapToInt(Integer::intValue).map(value -> value + 1).toArray();
        }

    }

    private void select(int index,int cnt){
        if(cnt == length/2){
            simulate();
        }else{
            for(int i=index;i<length;i++){
                choose[i] = true;
                select(i+1,cnt+1);
                choose[i] = false;
            }
        }
    }

    public int[] solution(int[][] dice) {
        length = dice.length;
        Dice = dice;
        choose = new boolean[length];
        select(0,0);
        return result;
    }
}