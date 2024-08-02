class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] == k) {
                return 1;
            }
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0, count = 0;
        
        for(int i=0; i<n; i++) {
            preSum += nums[i];

            if(map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
