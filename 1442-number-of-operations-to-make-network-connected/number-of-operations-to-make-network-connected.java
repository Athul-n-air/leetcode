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
    public int makeConnected(int n, int[][] connections) {
        Disjointset ds  = new Disjointset(n);
        int cntextra =0;
        for(int [] nums : connections){
            int u = nums[0];
            int v = nums[1];
            if(ds.findUPar(u)== ds.findUPar(v)){
                cntextra++;
            }else{
                ds.unionbysize(u,v);
            }
        } 
        int cntc =0;
        for(int i =0;i<n;i++){
            if(ds.findUPar(i)==i){
                cntc++;
            }
        }
        int ans = cntc - 1;
        if(cntextra>=ans)return ans;
        return -1;

    }
}