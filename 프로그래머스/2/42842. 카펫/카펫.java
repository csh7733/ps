class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1;i<=yellow;i++){
            int row = Math.min(i,yellow/i);
            int col = Math.max(i,yellow/i);
            if(row*col != yellow) continue;
            int total = (row+2)*2 + 2*col;
            if(total == brown){
                return new int[]{col+2,row+2};
            }
        }
        return new int[]{-1,-1};
    }
}