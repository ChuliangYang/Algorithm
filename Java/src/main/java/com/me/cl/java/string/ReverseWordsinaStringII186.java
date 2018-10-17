package com.me.cl.java.string;

/**
 * Given an input string , reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 */
public class ReverseWordsinaStringII186 {
    public void reverseWords(char[] str) {
        int start1 = 0;
        int end1 = str.length - 1;
        while (start1 < end1) {
            char temp = str[start1];
            str[start1] = str[end1];
            str[end1] = temp;
            start1++;
            end1--;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                start = i + 1;
                end = -1;
                continue;
            }
            if (i == str.length - 1 || str[i + 1] == ' ') {
                end = i;
                while (start < end) {
                    char temp = str[start];
                    str[start] = str[end];
                    str[end] = temp;
                    start++;
                    end--;
                }
            }
        }
    }
}
