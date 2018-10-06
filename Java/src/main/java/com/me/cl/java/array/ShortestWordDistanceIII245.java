package com.me.cl.java.array;

/**
 * 245.
 * Shortest Word Distance III
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int match=-1;
        int index=-1;
        int currentMin=-1;
        boolean same=false;
        if(word1.equals(word2)) same=true;
        for(int i=0;i<words.length;i++){
            String currentWord=words[i];
            if(same&&match==1){
                match=2;
            }
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
