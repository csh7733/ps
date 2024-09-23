import java.util.*;

class Solution {
    private ArrayList<int[]> intTime = new ArrayList<>();

    private int solve(int end,int index){
        int cnt = 0;
        for(int i=index+1;i<intTime.size();i++){
            int start = intTime.get(i)[0];
            if(start <= end+999) cnt++;
        }
        return cnt;
    }

    private void addTime(String time,String ms){
        String[] split = time.split(":");
        ms = ms.substring(0,ms.length()-1);
        int hh = Integer.parseInt(split[0]) * 3600 * 1000;
        int mm = Integer.parseInt(split[1]) * 60 * 1000;
        int ss = (int)(Double.parseDouble(split[2]) * 1000);
        int mss = (int)(Double.parseDouble(ms) * 1000);
        int end = hh + mm + ss;
        int start = end - (mss - 1);
        intTime.add(new int[]{start,end});
    }

    public int solution(String[] lines) {
        for(String line : lines){
            String[] split = line.split(" ");
            String time = split[1];
            String ms = split[2];
            addTime(time,ms);
        }
        int answer = 0;
        for(int i=0;i<intTime.size();i++){
            int end = intTime.get(i)[1];
            answer = Math.max(answer,solve(end,i));
        }
        return answer+1;
    }
}