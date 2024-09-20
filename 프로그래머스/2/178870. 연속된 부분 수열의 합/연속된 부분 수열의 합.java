class Solution {
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int left = 0,right = 0,size = 1;
        int[] result = new int[2];
        int sum = sequence[0];
        int ansSize = Integer.MAX_VALUE;
        while(right < length){
            if(sum == k){
                if(size < ansSize){
                    ansSize = size;
                    result[0] = left;
                    result[1] = right;
                }
                right++;
                if(right < length) sum += sequence[right];
                size++;
            }else if(sum < k){
                right++;
                if(right < length) sum += sequence[right];
                size++;
            }else if(sum > k){
                sum -= sequence[left++];
                size--;
            }
        }
        return result;
    }
}