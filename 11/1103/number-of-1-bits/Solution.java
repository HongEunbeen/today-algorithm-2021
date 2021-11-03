public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        String[] arr = Integer.toBinaryString(n).split("");
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("1")) count++;
        }
        return count;
    }
}
