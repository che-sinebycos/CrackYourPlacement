class Solution {
    int count;

    private void merge(int low, int mid, int high, int[] nums) {
        int i = low;
        int j = mid + 1;
        while(i <= mid && j <= high) {
            if(nums[i] > 2L*nums[j]) {
                count += (mid + 1 - i);
                j++;
            }
            else {
                i++;
            }
        }

        List<Integer> temp = new ArrayList<>();
        i = low; 
        j = mid+1;
        while(i <= mid && j <= high) {
            if(nums[i] <= nums[j]) {
                temp.add(nums[i++]);
            }
            else {
                temp.add(nums[j++]);
            }
        }
        while(i <= mid) {
            temp.add(nums[i++]);
        }
        while(j <= high) {
            temp.add(nums[j++]);
        }

        for(i=low; i<=high; i++) {
            nums[i] = temp.get(i-low);
        }
    }

    private void mergeSort(int low, int high, int[] nums) {
        if(low >= high) {
            return;
        }

        int mid = low + (high-low)/2;
        mergeSort(low, mid, nums);
        mergeSort(mid+1, high, nums);
        merge(low, mid, high, nums);
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        count = 0;
        mergeSort(0, n-1, nums);
        return count;
    }
}
