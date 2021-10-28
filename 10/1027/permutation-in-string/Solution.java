class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] t = s1.toCharArray();
        Arrays.sort(t);
        s1 = String.valueOf(t);
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            t = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(t);
            if (s1.equals(String.valueOf(t)))
                return true;
        }
        return false;
    }
}
