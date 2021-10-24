class Solution {
    public String reverseWords(String s) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        String arr[] = s.split(" ");
        
        for(int i=0; i<arr.length; i++){
            sb = new StringBuffer(arr[i]); 
            result += sb.reverse().toString();
            if(i != arr.length-1) result += " ";
        }
        return result;
    }
}
