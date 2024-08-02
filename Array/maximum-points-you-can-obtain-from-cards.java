class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int score = 0;
        for(int i=0; i<n; i++) {
            score += cardPoints[i];
        }
        if(n == k) {
            return score;
        }
        
        int i=0, j=0, windowSum = 0, minSum = Integer.MAX_VALUE;
        while(j < n) {
            windowSum += cardPoints[j];

            if(j-i+1 < n-k) {
                j++;
            }

            else if(j-i+1 == n-k) {
                minSum = Math.min(minSum, windowSum);
                windowSum -= cardPoints[i];
                i++;
                j++;
            }
        }

        return score - minSum;
    }
}