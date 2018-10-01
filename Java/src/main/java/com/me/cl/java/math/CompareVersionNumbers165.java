package com.me.cl.java.math;

/**
 * Created by CL on 10/1/18.
 */
public class CompareVersionNumbers165 {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int j=Math.max(v1.length,v2.length);
        for(int i=0;i<j;i++){
            int temp1=0;
            int temp2=0;
            if(i<=v1.length-1){
                temp1=Integer.parseInt(v1[i]);
            }
            if(i<=v2.length-1) temp2=Integer.parseInt(v2[i]);
            if(temp1>temp2) return 1;
            if(temp1<temp2) return -1;
        }
        return 0;
    }
}
