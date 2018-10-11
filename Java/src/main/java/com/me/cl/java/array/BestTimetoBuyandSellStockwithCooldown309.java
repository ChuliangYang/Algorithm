package com.me.cl.java.array;

/**
 * 309 Best Time to Buy and Sell Stock with Cooldown.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[] buybefore=new int[prices.length];
        int[] sellbefore=new int[prices.length];
        buybefore[0]=-prices[0];
        sellbefore[0]=0;
        int maxProfit=Math.max(buybefore[0],sellbefore[0]);
        for(int i=1;i<prices.length;i++){
            int currentBuyMax;
            int currentSellMax;
            if(i-2<0){
                currentBuyMax=-prices[i];
            }else{
                currentBuyMax=Math.max(sellbefore[i-2]-prices[i],-prices[i]);
            }
            currentSellMax=buybefore[i-1]+prices[i];
            buybefore[i]=Math.max(buybefore[i-1],currentBuyMax);
            sellbefore[i]=Math.max(sellbefore[i-1],currentSellMax);
            if(maxProfit<Math.max(buybefore[i],sellbefore[i])){
                maxProfit=Math.max(buybefore[i],sellbefore[i]);
            }
        }
        return maxProfit;
    }
}
