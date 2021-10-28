public class Solution {
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        
        int count = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] == 0){
                for(int j = i; j<count; j++){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                } 
            }
        }
    }
}
