package com.me.cl.java.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 387.
 * First Unique Character in a string
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString387 {
    Map<Character,Integer> characterIndex=new HashMap<>();
    List<Character> candidates=new ArrayList<>();
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            Character current=Character.valueOf(s.charAt(i));
            if(!characterIndex.containsKey(current)){
                characterIndex.put(current,i);
                candidates.add(current);
            }else if(characterIndex.get(current)>=0){
                candidates.remove(current);
                characterIndex.put(current,-1);
            }
        }
        if(candidates.size()==0) return -1;
        return characterIndex.get(candidates.get(0));
    }
}
