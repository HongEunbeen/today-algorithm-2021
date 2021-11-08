public class Solution {
    public boolean isPalindrome(int x) {
        if(x*-1 > 0) return false;
        String num = String.valueOf(x);
        StringBuffer sb = new StringBuffer(num); 
        if(sb.reverse().toString().equals(num)) return true;
        else return false;
    }
}
