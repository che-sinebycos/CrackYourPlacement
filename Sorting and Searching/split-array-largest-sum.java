class Solution {
    private boolean canSplit(int[] nums, int k, int mid) {
        int groups = 1;
        int subarraySum = 0;

        for(int i=0; i<nums.length; i++) {
            subarraySum += nums[i];
            if(subarraySum > mid) {
                groups += 1;
                subarraySum = nums[i];
            }
            if(groups > k) {
                return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int start = -1;
        int end = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] > start) {
                start = nums[i];
            }
            end += nums[i];
        }

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(canSplit(nums, k, mid)) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
