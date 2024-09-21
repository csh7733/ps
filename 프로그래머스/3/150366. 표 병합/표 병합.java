import java.util.*;

class Solution {

    private static int[] parent = new int[2501];
    private static String[] value = new String[2501];

    private int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    private int getIndex(int r,int c){
        return (r-1)*50 + c;
    }

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=1;i<=2500;i++){
            parent[i] = i;
            value[i] = "";
        }
        for(String command : commands){
            String[] split = command.split(" ");
            String cmd = split[0];
            if(cmd.equals("UPDATE")){
                if(split.length == 4){
                    int r = Integer.parseInt(split[1]);
                    int c = Integer.parseInt(split[2]);
                    int index = getIndex(r, c);
                    int unionIndex = find(index);
                    String val = split[3];
                    value[unionIndex] = split[3];
                }else{
                    String val1 = split[1];
                    String val2 = split[2];
                    for(int i=1;i<=2500;i++){
                        if(val1.equals(value[i])) value[i] = val2;
                    }
                }
            }else if(cmd.equals("MERGE")){
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                int index1 = getIndex(r1, c1);
                String value1 = value[find(index1)];
                int r2 = Integer.parseInt(split[3]);
                int c2 = Integer.parseInt(split[4]);
                int index2 = getIndex(r2, c2);
                String value2 = value[find(index2)];
                if(find(index1) == find(index2)) continue;
                value[find(index1)] = "";
                value[find(index2)] = "";
                int parent = find(index1);
                if(!value1.isEmpty() && !value2.isEmpty()){
                    value[parent] = value1;
                }else if(!value1.isEmpty()){
                    value[parent] = value1;
                }else if(!value2.isEmpty()){
                    value[parent] = value2;
                }
                union(index1,index2);
            }
            else if(cmd.equals("UNMERGE")){
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                int index = getIndex(r, c);
                int before = find(index);
                String beforeValue = value[before];
                List<Integer> deleteBuffer = new ArrayList<>();
                for(int i=1;i<=2500;i++){
                    if(find(i) == before) {
                        deleteBuffer.add(i);
                    }
                }
                for(Integer idx : deleteBuffer){
                    parent[idx] = idx;
                    value[idx] = "";
                }
                value[index] = beforeValue;
            }else if(cmd.equals("PRINT")){
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                int index = getIndex(r, c);
                int unionIndex = find(index);
                if(value[unionIndex].isEmpty()) answer.add("EMPTY");
                else answer.add(value[unionIndex]);
            }
        }

        return answer.toArray(new String[0]);
    }
}