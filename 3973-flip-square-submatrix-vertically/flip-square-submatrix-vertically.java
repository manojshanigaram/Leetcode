class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=x;i<x+k/2;i++){
            int or=x+k-1-(i-x);
            for(int j=y;j<y+k;j++){
                int t=grid[i][j];
                grid[i][j]=grid[or][j];
                grid[or][j]=t;
            }
        }
        return grid;
    }
}