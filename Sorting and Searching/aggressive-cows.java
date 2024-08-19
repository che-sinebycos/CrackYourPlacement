class Solution {
    private static boolean canPlaceCows(int[] stalls, int k, int m) {
        k -= 1;
        int lastCowPos = stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - lastCowPos >= m) {
                k -= 1;
                lastCowPos = stalls[i];
            }
            if(k == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        if(n == 2) {
            return stalls[1] - stalls[0];
        }
        
        int minDis = 1, maxDis = stalls[n-1] - stalls[0];
        
        while(minDis <= maxDis) {
            int mid = minDis + (maxDis - minDis)/2;
            if(canPlaceCows(stalls, k, mid)) {
                minDis = mid + 1;
            }
            else {
                maxDis = mid - 1;
            }
        }
        
        return maxDis;
    }
}
