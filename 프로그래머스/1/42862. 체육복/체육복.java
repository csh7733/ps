import java.util.*;

class Solution {
    int[] arr;
    public int solution(int n, int[] lost, int[] reserve) {
        arr = new int[n+1];
        Arrays.fill(arr,1);
        for(int i : lost){
            arr[i] -= 1;
        }
        for(int i : reserve){
            arr[i] += 1;
        }
        for(int i=1;i<=n;i++){
            if(arr[i] == 2){
                if(arr[i-1] == 0){
                    arr[i-1] = 1;
                    arr[i] = 1;
                }else if(i+1 <= n && arr[i+1] == 0){
                    arr[i+1] = 1;
                    arr[i] = 1;
                }
            }
        }
        int cnt =0;
        for(int i=1;i<=n;i++){
            if(arr[i] >= 1) cnt++;
        }
        return cnt;
    }
}