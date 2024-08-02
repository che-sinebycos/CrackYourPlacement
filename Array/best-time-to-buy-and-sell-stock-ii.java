class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) {
            return 0;
        }
        int[] curr = new int[2];
        int[] prev = new int[2];
        for(int i=n-1; i>=0; i--) {
            for(int buy = 1; buy >= 0; buy--) {
                int money = 0;
                if(buy == 1) {
                    money = Math.max(-prices[i] + curr[0], curr[1]);
                }
                else {
                    money = Math.max(prices[i] + curr[1], curr[0]);
                }
                
                prev[buy] = money;
            }
            curr = prev;
        }

        return prev[1];
    }
}