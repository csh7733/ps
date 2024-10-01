class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for(long n : numbers){
            String s = Long.toBinaryString(n);
            s = "0" + s;
            StringBuilder sb = new StringBuilder(s);
            for(int i=s.length()-1;i>=0;i--){
                if(sb.charAt(i) == '0'){
                    if(i == s.length()-1) {
                        sb.setCharAt(i,'1');
                    }else{
                        sb.setCharAt(i,'1');
                        sb.setCharAt(i+1,'0');
                    }
                    break;
                }
            }
            long temp = 0;
            long offset = 1;
            for(int i=sb.length()-1;i>=0;i--){
                if(sb.charAt(i) == '1') temp += offset;
                offset *= 2;
            }
            answer[index++] = temp;
        }
        return answer;
    }
}