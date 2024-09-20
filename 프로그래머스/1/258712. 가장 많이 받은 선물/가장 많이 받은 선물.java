import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> idx = new HashMap<>();
        int size = friends.length;
        for(int i=0;i<size;i++){
            idx.put(friends[i],i);
        }
        int[][] cnt = new int[size][size];
        int[] point = new int[size];
        for(String gift : gifts){
            String[] parts = gift.split(" ");
            int source = idx.get(parts[0]);
            int target = idx.get(parts[1]);
            cnt[source][target]++;
            point[source]++;
            point[target]--;
        }
        int[] next = new int[size];
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(cnt[i][j] > cnt[j][i]){
                    next[i]++;
                }else if(cnt[i][j] < cnt[j][i]){
                    next[j]++;
                }else if(point[i] > point[j]) {
                    next[i]++;
                }else if(point[i] < point[j]) {
                    next[j]++;
                }
            }
        }
        Arrays.sort(next);
        return next[size-1];
    }
}