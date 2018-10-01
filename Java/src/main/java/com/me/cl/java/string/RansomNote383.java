package com.me.cl.java.string;

/**
 * 383.
 * Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] availableNumbers=new int[26];
        for(int i=0;i<magazine.length();i++){
            availableNumbers[magazine.charAt(i)-'a']++;
        }
        for(char current:ransomNote.toCharArray()){
            if(availableNumbers[current-'a']>0){
                availableNumbers[current-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
