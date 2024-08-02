class Solution {
    public long findMinDiff (ArrayList<Integer> a, int n, int m) {
        if(n == 1) {
            return 0;
        }
        
        Collections.sort(a);
        
        int i=0, j=0;
        long minDiff = Long.MAX_VALUE;
        while(j < n) {
            if(j-i+1 < m) {
                j++;
            }
            
            else if(j-i+1 == m) {
                minDiff = Math.min(minDiff, a.get(j) - a.get(i));
                j++;
                i++;
            }
        }
        
        return minDiff;
    }
}