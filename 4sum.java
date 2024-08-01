class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 4) {
            return res;
        }

        Arrays.sort(nums);
        for(int i=0; i<n-3; i++) {
            if(i == 0 || (i != 0 && nums[i] != nums[i-1])) {
                for(int j = i+1; j<n-2; j++) {
                    if(j == i+1 || (j != i+1 && nums[j] != nums[j-1])) {
                        long remTarget = target*1L - nums[i] - nums[j];
                        int k = j+1, l = n-1;
                        while(k < l) {
                            if(nums[k] + nums[l] == remTarget) {
                                int first = nums[k], second = nums[l];
                                res.add(Arrays.asList(nums[i], nums[j], first, second));
                                while(k < l && nums[k] == first) {
                                    k++;
                                }
                                while(k < l && nums[l] == second) {
                                    l--;
                                }
                            }
                            else if(nums[k] + nums[l] < remTarget) {
                                k++;
                            }
                            else {
                                l--;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
