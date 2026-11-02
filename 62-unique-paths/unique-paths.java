class Solution {
    int f(int i ,int j ,ArrayList<ArrayList<Integer>> dp ){
        if(i==0 && j == 0)return 1;
        if(i<0 ||j<0)return 0;
        if(dp.get(i).get(j)!=-1)return dp.get(i).get(j);
        int up = f(i-1,j,dp);
        int left = f(i,j-1,dp);
        dp.get(i).set(j, left + up);
        return dp.get(i).get(j);
    }
    public int uniquePaths(int m, int n) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i = 0 ; i<m;i++){
        dp.add(new ArrayList<>(Collections.nCopies(n,-1)));
        }
        return f(m-1,n-1,dp);
        
    }
}