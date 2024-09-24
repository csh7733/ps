import java.util.*;
class Solution {
    Map<String,Integer> idx = new HashMap<>();
    Map<Integer,String> name = new HashMap<>();
    int[][] canVisit;
    List<Integer>[] dests;
    ArrayList<Integer> intAnswer = new ArrayList<>();
    String[] answer;

    private void dfs(int cur,int cnt,int N){
        if(cnt == N && answer == null){
            answer = new String[N+1];
            answer[0] = "ICN";
            for(int i=0;i<N;i++){
                answer[i+1] = name.get(intAnswer.get(i));
            }
            return;
        }
        for(int i=0;i<dests[cur].size();i++){
            int dest = dests[cur].get(i);
            if(canVisit[cur][dest] == 0) continue;
            canVisit[cur][dest]--;
            intAnswer.add(dest);
            dfs(dest,cnt+1,N);
            intAnswer.remove(intAnswer.size()-1);
            canVisit[cur][dest]++;
        }
    }

    public String[] solution(String[][] tickets) {
        int cnt = 0;
        dests = new List[tickets.length+1];
        canVisit = new int[tickets.length+1][tickets.length+1];
        for(int i=0;i<dests.length;i++){
            dests[i] = new ArrayList<>();
        }
        for(String[] ticket : tickets){
            String src = ticket[0];
            String dest = ticket[1];
            if(!idx.containsKey(src)){
                idx.put(src,cnt);
                name.put(cnt++,src);
            }
            if(!idx.containsKey(dest)){
                idx.put(dest,cnt);
                name.put(cnt++,dest);
            }

            Integer srcIndex = idx.get(src);
            Integer destIndex = idx.get(dest);

            dests[srcIndex].add(destIndex);
            canVisit[srcIndex][destIndex]++;
        }
        for(int i=0;i<dests.length;i++){
            dests[i].sort((o1, o2) -> {
                return name.get(o1).compareTo(name.get(o2));
            });
        }
        dfs(idx.get("ICN"),0,tickets.length);
        return answer;
    }
}