import java.util.*;

class Solution {

    private boolean[] check = new boolean[11];
    private int[] result = new int[11];
    private int diff = Integer.MIN_VALUE;

    private void solve(int n, int[] info){
        int lion = 0;
        int peach = 0;
        int[] myResult = new int[11];
        for(int i=0;i<10;i++){
            if(check[i]){
                n -= (info[i]+1);
                myResult[i] = info[i]+1;
                lion += (10-i);
            }else{
                if(info[i] > 0) peach += (10-i);
            }
            if(n<0) return;
        }
        if(lion > peach){
            if(lion-peach > diff){
                diff = lion-peach;
                if(n>0) myResult[10] = n;
                result = myResult;
            }else if(lion-peach == diff){
                for(int i=10;i>=0;i--){
                    if(myResult[i] == 0 && result[i] == 0) continue;
                    if(myResult[i] > result[i]){
                        result = myResult;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    private void select(int index,int n, int[] info){
        if(index ==10){
            solve(n,info);
            return;
        }
        check[index] = true;
        select(index+1,n,info);
        check[index] = false;
        select(index+1,n,info);
    }
    public int[] solution(int n, int[] info) {
        select(0,n,info);
        if(diff == Integer.MIN_VALUE) return new int[]{-1};
        else return result;
    }
}