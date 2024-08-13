class Solution {
    static int findFloor(long arr[], int n, long x) {
        if(n == 1) {
            return (arr[0] <= x) ? 0 : -1;
        }
        
        int low = 0, high = n-1, ans = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(arr[mid] == x) {
                return mid;
            }
            else if(arr[mid] < x) {
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        return ans;
    }
}
