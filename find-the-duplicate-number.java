class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 2) {
            return nums[0];
        }
        
        for(int i=0; i<n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) {
                return idx + 1;
            }
            nums[idx] = -nums[idx];
        }
        
        return -1;
    }
}
