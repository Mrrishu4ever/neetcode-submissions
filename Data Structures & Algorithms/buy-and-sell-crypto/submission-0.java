class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }

        return profit;
    }
}