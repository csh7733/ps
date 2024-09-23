class Solution {
    int[] cnt = new int[10001];
    public int solution(int[] citations) {
        for(int citation : citations){
            cnt[citation]++;
        }
        int total = 0, answer = 0;
        for(int i=10000;i>=0;i--){
            total += cnt[i];
            if(total >= i && citations.length - total <= i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}