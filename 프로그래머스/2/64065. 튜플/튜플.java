class Solution {
    public int[] solution(String s) {
        int[] arr = new int[100001];
        s = s.replaceAll("[{}]","");
        String[] split = s.split(",");
        int max = 0;
        for(String sp : split){
            int i = Integer.parseInt(sp);
            arr[i]++;
        }
        for(int i=1;i<=100000;i++){
            max = Math.max(max,arr[i]);
        }
        int[] result = new int[max];
        for(int i=1;i<=100000;i++){
            if(arr[i] > 0){
                result[max-arr[i]] = i;
            }
        }

        return result;
    }
}