class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] % k == 0) {
                return 1;
            }
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, ans = 0;
        for(int i=0; i<n; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
