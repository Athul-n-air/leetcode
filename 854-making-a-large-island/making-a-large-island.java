class Disjointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    Disjointset(int n){
        for(int i = 0; i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    int find(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp_node = find(parent.get(node));
        parent.set(node,ulp_node);
        return parent.get(node);
    }
    void union(int u , int v){
        int ulpu = find(u);
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
    public int largestIsland(int[][] grid) {
        int n  = grid.length;
        Disjointset ds = new Disjointset(n*n);
        for(int row = 0;row<n;row++){
            for(int col = 0 ;col<n;col++){
                int dr[] = {0,1,0,-1};
                int dc[] = {1,0,-1,0};
                if(grid[row][col]==0)continue;
                for(int i = 0; i<4;i++){
                    int newr = row + dr[i];
                    int newc = col + dc[i];
                    if(newr<n && newr>-1 && newc<n && newc>-1 && grid[newr][newc]==1){
                        int node = row * n + col;
                        int adjn = newr*n +newc;
                        ds.union(node,adjn);
                    }
                }
            }
        }
        int mx = 0;
        for(int row = 0;row<n;row++){
            for(int col = 0 ;col<n;col++){
                int dr[] = {0,1,0,-1};
                int dc[] = {1,0,-1,0};
                if(grid[row][col]==1)continue;
                HashSet<Integer> components = new HashSet<>();
                for(int i = 0; i<4;i++){
                    int newr = row + dr[i];
                    int newc = col + dc[i];
                    if(newr<n && newr>-1 && newc<n && newc>-1 && grid[newr][newc]==1){
                        components.add(ds.find(newr*n +newc));
                    }
                }
                int sizetotal = 0;
                for(Integer parent : components){
                    sizetotal += ds.size.get(parent);
                }
                mx = Math.max(mx,sizetotal+1);
            }
        }
        for (int i = 0; i < n * n; i++) {

            if (grid[i / n][i % n] == 1) {
                mx = Math.max(mx, ds.size.get(ds.find(i)));
            }
        }
        return mx;
        
    }
}