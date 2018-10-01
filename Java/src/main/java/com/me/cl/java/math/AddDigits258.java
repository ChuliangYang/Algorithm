package com.me.cl.java.math;

/**
 * 258.
 * Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits258 {
    public int addDigitsRecursive(int num){
        int sum=0;
        while(num!=0){
            int lowest=num%10;
            num=num/10;
            sum=sum+lowest;
        }
        if(sum>=10){
            return addDigitsRecursive(sum);
        }else{
            return sum;
        }

    }
}
