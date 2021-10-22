class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=nums.length-1; i>=0; i--){
            queue.add(nums[i]);
        }
        
        while(k-- > 0){
            queue.add(queue.poll());
        }
        
        Object[] obj = queue.toArray();
        for(int i=0; i<nums.length; i++){
            nums[i] = (Integer) obj[nums.length-i-1];
        }
    }
}
