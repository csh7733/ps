class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long n : numbers){
            int index = 0;
            for(int i=0;;i++){
                if((n&(1L<<i)) == 0){
                    index = i;
                    break;
                }
            }
            if(index == 0) n |= 1;
            else{
                n |= (1L<<index);
                n &= ~(1L<<(index-1));
            }
            answer[idx++] = n;
        }
        return answer;
    }
}