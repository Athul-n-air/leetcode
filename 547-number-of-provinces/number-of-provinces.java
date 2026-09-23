class Disjointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    Disjointset(int n){
        for(int i = 0; i<=n ; i++){
            parent.add(i);
            size.add(0);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp =findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionbysize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v)return ;
        if(ulp_u<ulp_v){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Disjointset ds = new Disjointset(n);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j]==1){
                    ds.unionbysize(i,j);
                }
            }

        }
        int cnt = 0;
        for(int i  = 0;i<n;i++){
            if(ds.parent.get(i)==i){
                cnt++;
            }
        }
        return cnt;
    }
}