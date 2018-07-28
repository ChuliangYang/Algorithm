package com.me.cl.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CL on 7/27/18.
 */
public class TwoDArray {

//    Diagonal Traverse
//    Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
//
//    Example:
//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    Output:  [1,2,4,7,5,3,6,8,9]
//    Explanation:
//
//    Note:
//    The total number of elements of the given matrix will not exceed 10,000.

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[]{};
        }
        int totalRows=matrix.length;
        int totalColums=matrix[0].length;
        int totalAmount=totalRows*totalColums;
        int[] results=new int[totalAmount];
        int feedIndex=0;
        int[] currentIndex={0,0};
        boolean travelDown=false;
        while(feedIndex<=totalAmount-1){
            int[] traveleIndex=currentIndex;
            while(true){
                results[feedIndex++]=matrix[traveleIndex[0]][traveleIndex[1]];
                int[] temp=findNextIndex(travelDown,traveleIndex[0],traveleIndex[1]);
                if(checkIndexValid(totalRows,totalColums,temp[0],temp[1])){
                    traveleIndex=temp;
                    continue;
                }else{

                    break;
                }
            }
            if(travelDown){
                if(checkIndexValid(totalRows,totalColums,traveleIndex[0]+1,traveleIndex[1])){
                    currentIndex[0]=traveleIndex[0]+1;
                    currentIndex[1]=traveleIndex[1];
                }else if(checkIndexValid(totalRows,totalColums,traveleIndex[0],traveleIndex[1]+1)){
                    currentIndex[0]=traveleIndex[0];
                    currentIndex[1]=traveleIndex[1]+1;
                }else{
                    break;
                }
            }else{
                if(checkIndexValid(totalRows,totalColums,traveleIndex[0],traveleIndex[1]+1)){
                    currentIndex[0]=traveleIndex[0];
                    currentIndex[1]=traveleIndex[1]+1;
                }else if(checkIndexValid(totalRows,totalColums,traveleIndex[0]+1,traveleIndex[1])){
                    currentIndex[0]=traveleIndex[0]+1;
                    currentIndex[1]=traveleIndex[1];
                }else{
                    break;
                }
            }
            travelDown=!travelDown;
        }
        return results;
    }

    private boolean checkIndexValid(int totalRows, int totalColums, int row, int colum){
        if(row<0||colum<0){
            return false;
        }
        if(row>totalRows-1||colum>totalColums-1){
            return false;
        }
        return true;
    }

    private int[] findNextIndex(Boolean down, int currentRowIndex, int currentColumIndex){
        int[] result={-1,-1};

        if(down){
            result[0]=currentRowIndex+1;
            result[1]=currentColumIndex-1;
        }else{
            result[0]=currentRowIndex-1;
            result[1]=currentColumIndex+1;
        }
        return result;

    }


//    Spiral Matrix
//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//    Example 1:
//
//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    Output: [1,2,3,6,9,8,7,4,5]
//    Example 2:
//
//    Input:
//            [
//            [1, 2, 3, 4],
//            [5, 6, 7, 8],
//            [9,10,11,12]
//            ]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]


    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList();
        }
        List<Integer> results=new ArrayList<>();
        int a=0;
        int b=0;
        while((a<=(matrix.length-1)/2)&&(b<=(matrix[0].length-1)/2)){
            int rightest=matrix[0].length-b-1;
            int bottom=matrix.length-a-1;
            for(int i=b;i<=rightest;i++){
                results.add(matrix[a][i]);
            }
            for(int i=a+1;i<=bottom;i++){
                results.add(matrix[i][rightest]);
            }
            if(bottom!=a){
                for(int i=rightest-1;i>=b;i--){
                    results.add(matrix[bottom][i]);
                }
            }
            if(rightest!=b){
                for(int i=bottom-1;i>a;i--){
                    results.add(matrix[i][b]);
                }
            }

            a+=1;
            b+=1;
        }

        return results;
    }

//    Pascal's Triangle
//    Go to Discuss
//    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//    Example:
//
//    Input: 5
//    Output:
//            [
//            [1],
//            [1,1],
//            [1,2,1],
//            [1,3,3,1],
//            [1,4,6,4,1]
//            ]

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> lastRow=new ArrayList<>();
        int workRow=1;
        while(workRow<=numRows){
            List<Integer> currentRow=new ArrayList<>();
            if(workRow==1){
                currentRow.add(1);
            }

            if(lastRow.size()>0){
                currentRow.add(1);
                for(int i=0;i<=lastRow.size()-2;i++){
                    currentRow.add(lastRow.get(i)+lastRow.get(i+1));
                }
                currentRow.add(1);
            }
            results.add(currentRow);
            lastRow=currentRow;
            workRow++;
        }
        return results;
    }

}
