class Solution {

    private int isTree(int left,int right,String binary){
        if(left == right){
            return Integer.parseInt(String.valueOf(binary.charAt(left)));
        }
        int mid = (left+right)/2;
        if(isTree(left,mid-1,binary) == -1 || isTree(mid+1,right,binary) == -1) return -1;
        if(isTree(left,mid-1,binary) == 1 || isTree(mid+1,right,binary) == 1){
            if(binary.charAt(mid) == '1') return 1;
            else return -1;
        }
        return Integer.parseInt(String.valueOf(binary.charAt(mid)));
    }

    public int[] solution(long[] numbers) {
        int length = numbers.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int binaryLength = binary.length();
            int offset = 1;
            while (true) {
                if (binaryLength > getNumber(offset)) {
                    if(binaryLength < getNumber(offset + 1)){
                        int diff = getNumber(offset + 1) - binaryLength;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < diff; j++) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(binary);
                        binary = stringBuilder.toString();
                        break;
                    }else{
                        offset++;
                    }
                } else if (binaryLength == getNumber(offset)) {
                    break;
                }
            }
            binaryLength = binary.length();
            if(isTree(0,binaryLength-1,binary) != -1) result[i] = 1;
        }

        return result;
    }

    private static int getNumber(int offset) {
        return (int) (Math.pow(2, offset)) - 1;
    }

}