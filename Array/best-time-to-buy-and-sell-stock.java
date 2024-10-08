class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<n; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}