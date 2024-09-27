import java.util.*;

class Solution {
    private Map<String,Integer> dic = new HashMap<>();
    private int index = 1;
    private void init(){
        dic.put("A",index++);
        dic.put("B",index++);
        dic.put("C",index++);
        dic.put("D",index++);
        dic.put("E",index++);
        dic.put("F",index++);
        dic.put("G",index++);
        dic.put("H",index++);
        dic.put("I",index++);
        dic.put("J",index++);
        dic.put("K",index++);
        dic.put("L",index++);
        dic.put("M",index++);
        dic.put("N",index++);
        dic.put("O",index++);
        dic.put("P",index++);
        dic.put("Q",index++);
        dic.put("R",index++);
        dic.put("S",index++);
        dic.put("T",index++);
        dic.put("U",index++);
        dic.put("V",index++);
        dic.put("W",index++);
        dic.put("X",index++);
        dic.put("Y",index++);
        dic.put("Z",index++);

    }
    public int[] solution(String msg) {
        init();
        String cur = "";
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<msg.length();i++){
            String next = cur+msg.charAt(i);
            if(dic.containsKey(next)) {
                cur = next;
                continue;
            }
            Integer key = dic.get(cur);
            result.add(key);
            dic.put(next,index++);
            cur = msg.substring(i,i+1);
        }
        result.add(dic.getOrDefault(cur,index));
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}