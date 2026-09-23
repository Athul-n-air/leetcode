class Solution {
    private void dfs(int row , int col, int[][] image, int[][] ans,int delrow[], int delcol[],int inicolor,int newcolor){
        ans[row][col] = newcolor;
        int n = image.length;
        int m  = image[0].length;
        for(int i =0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!= newcolor &&  image[nrow][ncol] == inicolor){
                dfs(nrow,ncol,image,ans,delrow,delcol,inicolor,newcolor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m  = image[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0;i<=image.length-1;i++){
            for(int j = 0 ; j<=image[0].length-1;j++){
                ans[i][j] = image[i][j];
            }
        }
        int inicolor = image[sr][sc];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};
        dfs(sr,sc,image,ans,delrow,delcol,inicolor,color);
        return ans;
    }
}