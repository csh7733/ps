class Solution {

    private char[] chars = {'A','E','I','O','U'};
    private int answer;
    private int cnt;

    private void dfs(String word,int index,StringBuilder sb){
        if(sb.toString().equals(word)) answer = cnt;
        for(int i=0;i<5;i++){
            if(index<5){
                sb.append(chars[i]);
                cnt++;
                dfs(word,index+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(word,0,sb);
        return answer;
    }
}
