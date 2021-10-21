/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        
        while(left < right){
            mid = left + (right-left)/2;
            boolean flag = isBadVersion(mid);
            if(flag && !isBadVersion(mid-1)) return mid;
            else if(flag) right = mid;
            else if(!flag) left = mid +1;
        }
        return left;
    }
}
