class Solution {
    public void setZeroes(int[][] matrix) {
        int n  = matrix.length;
        int m  = matrix[0].length;
        
        boolean[] rowzero = new boolean[n];
        boolean[] colzero = new boolean[m];
        for(int i  =0 ;i<n;i++){
            for(int j = 0; j<m;j++){
                if(matrix[i][j]==0){
                    rowzero[i]=true;
                    colzero[j]=true;
                }
            }
        } 

        for(int i  = 0; i<rowzero.length;i++){
            if(rowzero[i]==true){
                for(int j = 0; j<m;j++){
                    matrix[i][j]=0;
                }

            }
        }
         for(int i  = 0; i<colzero.length;i++){
            if(colzero[i]==true){
                for(int j = 0; j<n;j++){
                    matrix[j][i]=0;
                }

            }
        }
    }
}