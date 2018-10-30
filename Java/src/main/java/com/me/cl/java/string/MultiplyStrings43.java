package com.me.cl.java.string;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        if(num1.length()==0||num2.length()==0) return "0";
        int[] resultArray=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int weight1=num1.length()-1-i;
            for(int j=num2.length()-1;j>=0;j--){
                int weight2=num2.length()-1-j;
                resultArray[weight1+weight2]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        StringBuilder resultBuilder=new StringBuilder();
        int plus=0;
        int leadingZero=-1;
        for(int k=0;k<resultArray.length;k++){
            int current=plus+resultArray[k];
            if(current>=10){
                plus=current/10;
                current=current%10;
            }else{
                plus=0;
            }
            if(current!=0){
                leadingZero=-1;
            }else{
                if(leadingZero==-1) leadingZero=k;
            }
            resultBuilder.append(current);
        }
        if(leadingZero!=-1){
            resultBuilder.delete(leadingZero,resultBuilder.length());
        }
        resultBuilder.reverse();
        if(resultBuilder.length()==0) resultBuilder.append('0');
        return resultBuilder.toString();
    }
}
