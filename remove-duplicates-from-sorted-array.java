class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 2) {
            if(nums[0] == nums[1]) {
                return 1;
            }
            return 2;
        }
        
        int i=0, j=1;
        while(j < n) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        
        return i+1;
    }
}
