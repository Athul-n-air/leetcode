class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<10;i++){
            dfs(i,n,ans);
        }
        return ans;
    }
    public void dfs(int num,int n,List<Integer>ans){
        if(num>n)return;
        ans.add(num);
        for(int i = 0;i<10;i++){
            int ln = num*10+i;
            if(ln>n){
                break;
            }
            dfs(ln,n,ans);
        }
        return;
    }
}