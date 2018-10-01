package com.me.cl.java.DFS_BFS;

/**
 * 200.
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberofIslands200 {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int count=0;
        visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    if(!visited[i][j]){
                        visit(i,j,grid);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void visit(int i,int j,char[][] grid){
        if(grid[i][j]=='1'){
            visited[i][j]=true;
            if(i>=1&&!visited[i-1][j]) visit(i-1,j,grid);
            if(i<visited.length-1&&!visited[i+1][j]) visit(i+1,j,grid);
            if(j>=1&&!visited[i][j-1]) visit(i,j-1,grid);
            if(j<visited[0].length-1&&!visited[i][j+1]) visit(i,j+1,grid);
        }
    }
}
