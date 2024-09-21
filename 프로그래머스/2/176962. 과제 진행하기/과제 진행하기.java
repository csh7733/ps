import java.util.*;

class Solution {
    static class Plan{
        private String name;
        private Integer start;
        private Integer remain;

        public Plan(String[] plan){
            this.name = plan[0];
            this.start = toTime(plan[1]);
            this.remain= Integer.parseInt(plan[2]);
        }

        public Plan(String name,Integer remain){
            this.name = name;
            this.remain= remain;
        }

    }
    private static Integer toTime(String time){
        String[] split = time.split(":");
        int hh = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        return hh*60+mm;
    }
    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> tasks = new PriorityQueue<>((t1,t2)-> t1.start-t2.start);
        Stack<Plan> remainTask = new Stack<>();
        for(String[] plan : plans){
            tasks.offer(new Plan(plan));
        }
        ArrayList<String> answer = new ArrayList<>();
        while(!tasks.isEmpty()){
            Plan cur = tasks.poll();
            if(!tasks.isEmpty()){
                Plan next = tasks.peek();
                int diff = next.start-cur.start;
                if(diff<cur.remain){
                    remainTask.add(new Plan(cur.name,cur.remain-diff));
                }else if(diff == cur.remain){
                    answer.add(cur.name);
                }else{
                    answer.add(cur.name);
                    int remain = diff - cur.remain;
                    while(remain != 0 && !remainTask.isEmpty()){
                        Plan top = remainTask.pop();
                        if(top.remain > remain){
                            remainTask.push(new Plan(top.name,top.remain-remain));
                            remain = 0;
                        }else{
                            answer.add(top.name);
                            remain -= top.remain;
                        }
                    }
                }
            }else{
                answer.add(cur.name);
            }
        }
        while(!remainTask.isEmpty()){
            Plan top = remainTask.pop();
            answer.add(top.name);
        }
        return answer.toArray(new String[0]);
    }
}