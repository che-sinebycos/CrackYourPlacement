class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n <= 2) {
            return nums[0];
        }

        int candidate = nums[0], vote = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] == candidate) {
                vote++;
            }
            else if(vote == 0) {
                candidate = nums[i];
                vote = 1;
            }
            else {
                vote--;
            }
        }
        return candidate;
    }
}
