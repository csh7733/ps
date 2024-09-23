import java.util.*;
class Solution {

    Map<String,Integer> dist;

    private boolean canConvert(String src,String dest){
        int cnt = 0;
        for(int i=0;i<src.length();i++){
            if(src.charAt(i) != dest.charAt(i)) cnt++;
        }
        return cnt == 1;
    }

    private void bfs(String begin, String[] words){
        Queue<String> q = new LinkedList<>();
        dist.put(begin,0);
        q.offer(begin);
        while(!q.isEmpty()){
            String poll = q.poll();
            for(int i=0;i< words.length;i++){
                if(!dist.containsKey(words[i]) && canConvert(poll,words[i])){
                    dist.put(words[i],dist.get(poll)+1);
                    q.offer(words[i]);
                }
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        dist = new HashMap<>();
        bfs(begin,words);
        return dist.getOrDefault(target, 0);
    }
}