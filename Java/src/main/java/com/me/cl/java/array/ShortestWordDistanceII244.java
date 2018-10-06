package com.me.cl.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244.
 * Shortest Word Distance II
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceII244 {
    class WordDistance {
        Map<String,List<Integer>> positionMap=new HashMap<>();

        public WordDistance(String[] words) {
            for(int i=0;i<words.length;i++){
                String word=words[i];
                if(positionMap.get(word)==null){
                    positionMap.put(word,new ArrayList<Integer>());
                }
                positionMap.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> positionW1=positionMap.get(word1);
            List<Integer> positionW2=positionMap.get(word2);
            int minDistance=-1;
            if(positionW1==null||positionW2==null)  return -1;
            for(Integer indexW1:positionW1){
                for(Integer indexW2:positionW2){
                    int distance=Math.abs(indexW1-indexW2);
                    if(minDistance==-1) minDistance=distance;
                    minDistance=Math.min(distance,minDistance);
                }
            }
            return minDistance;
        }
    }
}
