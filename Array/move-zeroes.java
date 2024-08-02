class Solution {
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return;
        }

        int i = -1, j = 0;
        while(j < n) {
            if(nums[j] != 0) {
                i++;
                if(i != j) {
                    swap(nums, i, j);
                }
            }
            j++;
        } 
    }
}