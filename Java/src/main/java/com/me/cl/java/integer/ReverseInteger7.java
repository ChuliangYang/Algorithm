package com.me.cl.java.integer;

/**
 * 7.
 * Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        int overFlowBoundPositive=Integer.MAX_VALUE/10;
        int overFlowBoundNegative=Integer.MIN_VALUE/10;
        int result=0;
        while(x!=0){
            int lowest=x%10;
            x/=10;
            if(result<overFlowBoundPositive&&result>overFlowBoundNegative){
                result=result*10+lowest;
            }else if(result>0&&result<=(Integer.MAX_VALUE-lowest)/10){
                result=result*10+lowest;
            }else if(result<0&&result>=(Integer.MIN_VALUE-lowest)/10){
                result=result*10+lowest;
            }else{
                return 0;
            }
        }
        return result;
    }
}
