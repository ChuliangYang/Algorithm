package com.me.cl.java.array;

/**
 * Created by CL on 10/11/18.
 */
public class ContainerWithWater11 {
    int result=0;
    public int maxArea(int[] height) {
        maxArea(height,-1,-1);
        return result;
    }

    public void maxArea(int[] height, int one, int two){
        int decisionState=-1;
        if(one==-1){
            decisionState=1;
        }else if(two==-1){
            decisionState=2;
        }else{
            decisionState=3;
        }
        if(decisionState==3){
            int area=Math.min(height[one],height[two])*(two-one);
            result=Math.max(result,area);
            return;
        }
        if(decisionState==1){
            for(int i=0;i<height.length-1;i++){
                maxArea(height,i,-1);
            }
        }
        if(decisionState==2){
            for(int i=one+1;i<height.length;i++){
                maxArea(height,one,i);
            }
        }

    }
}
