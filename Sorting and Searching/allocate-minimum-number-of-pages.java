class Solution {
    private static boolean canAllocate(int[] arr, int mid, int m) {
        int books = 0, student = 1;
        for(int i=0; i<arr.length; i++) {
            books += arr[i];
            if(books > mid) {
                student += 1;
                books = arr[i];
            }
            if(student > m) {
                return false;
            }
        }
        return true;
    }
    
    public static long findPages(int n, int[] arr, int m) {
        if(m > n) {
            return -1;
        }
        
        int low = 0, high = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > low) {
                low = arr[i];
            }
            high += arr[i];
        }
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(canAllocate(arr, mid, m)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        
        return low;
    }
};
