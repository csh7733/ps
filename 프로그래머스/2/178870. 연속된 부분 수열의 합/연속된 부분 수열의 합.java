class Solution {

    private int findRight(int[] sum,int start,int end,int k){
        int left = start;
        int right = end;
        int total = 0;
        while(left<=right){
            int mid = (left+right)/2;
            total = sum[mid+1] - sum[start];
            if(total < k) left = mid + 1;
            if(total > k) right = mid - 1;
            if(total == k) {
                return mid;
            }
        }
        return -1;
    }
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int[] sum = new int[length+1];
        for(int i=1;i<=length;i++){
            sum[i] = sum[i-1] + sequence[i-1];
        }
        int size = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int i=0;i<length;i++){
            int left = i;
            int right = findRight(sum,left,length-1,k);
            if(right != -1){
                if(right - left + 1 < size){
                    size = right -left + 1;
                    result[0] = left;
                    result[1] = right;
                }
            }

        }
        return result;
    }
}