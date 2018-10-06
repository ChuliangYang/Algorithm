package com.me.cl.java.array;

/**
 * 243.
 * Shortest Word Distance
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
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
public class ShortestWordDistance243 {
    public int shortestDistance(String[] words, String word1, String word2){
        int match=-1;
        int index=-1;
        int currentMin=-1;
        for(int i=0;i<words.length;i++){
            String currentWord=words[i];
            if(currentWord.equals(word1)){
                if(match==-1) {
                    index=i;
                    match=1;
                }
                if(match==1) index=i;
                if(match==2){
                    int distance=i-index;
                    index=i;
                    match=1;
                    if(currentMin==-1){
                        currentMin=distance;
                    }else{
                        currentMin=Math.min(currentMin,distance);
                    }
                }

            }else if(currentWord.equals(word2)){
                if(match==-1) {
                    index=i;
                    match=2;
                }
                if(match==2) index=i;
                if(match==1){
                    int distance=i-index;
                    index=i;
                    match=2;
                    if(currentMin==-1){
                        currentMin=distance;
                    }else{
                        currentMin=Math.min(currentMin,distance);
                    }
                }
            }
        }
        return currentMin;
    }
}
