class Disjointset{
    List<Integer>parent  = new ArrayList<>();
    List<Integer>size = new ArrayList<>();
    Disjointset(int n){
        for(int i  = 0; i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    int find(int node){
        if(node==parent.get(node))return node;
        int ulp = find(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    void union(int u ,int  v){
        int ulpu  = find(u);
        int ulpv = find(v);
        if(ulpu==ulpv){
            return ;
        }
        if(size.get(ulpu)<=size.get(ulpv)){
            parent.set(ulpu,ulpv);
            size.set(ulpv,size.get(ulpu)+size.get(ulpv));
        }else{
            parent.set(ulpv,ulpu);
            size.set(ulpu,size.get(ulpu)+size.get(ulpv)); 
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxrow =0;
        int maxcol = 0;
        for(int i = 0;i<n;i++){
            int row = stones[i][0];
            int col =stones[i][1];
            maxrow = Math.max(maxrow,row);
            maxcol = Math.max(maxcol,col);
        }
        Disjointset ds = new Disjointset(maxrow + maxcol + 2);
        HashMap<Integer,Integer> stonesnode = new HashMap<>();
        for(int i  = 0 ; i<n ;i++){
            int noderow = stones[i][0];
            int nodecol = stones [i][1]+maxrow+1;
            ds.union(noderow,nodecol);
            stonesnode.put(noderow,1);
            stonesnode.put(nodecol,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> it : stonesnode.entrySet()){
            if(ds.find(it.getKey())==it.getKey())cnt++;
        }
        return n - cnt;
    }
}