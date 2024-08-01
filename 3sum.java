class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                res.add(Arrays.asList(nums[0], nums[1], nums[2]));
            }
            return res;
        }
        
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++) {
            if(i == 0 || (i != 0 && nums[i] != nums[i-1])) {
                int remSum = -nums[i];
                int j = i+1, k = n-1;
                while(j < k) {
                    if(nums[j] + nums[k] == remSum) {
                        int first = nums[j], second = nums[k];
                        res.add(Arrays.asList(nums[i], first, second));
                        
                        while(j < k && nums[j] == first) {
                            j++;
                        }
                        while(j < k && nums[k] == second) {
                            k--;
                        }
                    }
                    else if(nums[j] + nums[k] < remSum) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}
