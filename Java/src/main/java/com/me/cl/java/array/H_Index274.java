package com.me.cl.java.array;

import java.util.Arrays;

/**
 * 274.
 * H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class H_Index274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
            int count= citations.length-i;
            if(count==citations[i]) return count;
            if(count<citations[i]&&i-1>=0&&count>citations[i-1]) return count;
            if(citations[i]!=0&&count-1==citations[i]) return count-1;
            if(i==0&&citations[i]>count) return count;
        }
        return 0;
    }
}
