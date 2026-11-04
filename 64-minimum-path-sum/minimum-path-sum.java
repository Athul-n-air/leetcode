class Solution {
    int f(int i, int j ,int[][]grid ,ArrayList<ArrayList<Integer>> dp){
        if(i==0 && j == 0)return grid[i][j];
        if(i<0 ||j<0) return(int) 1e9;
        if(dp.get(i).get(j)!=-1)return dp.get(i).get(j);
        int up = grid[i][j] + f(i-1,j,grid,dp);
        int left = grid[i][j] + f(i,j-1,grid,dp);
        dp.get(i).set(j,Math.min(left,up));
        return dp.get(i).get(j);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i = 0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(m,-1)));
        }
        return f(n-1,m-1,grid,dp);
    }
}