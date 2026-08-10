class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,0,1));
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,1,-1,1,0,-1};
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int r = cur.row;
            int c = cur.col;
            int d = cur.dist;
            if(d>dist[r][c])continue;
            if(r==n-1 && c ==n-1)return d;
            for(int i=0;i<8;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                   int nd = d+1;
                    if(nd<dist[nr][nc]){
                        dist[nr][nc] = nd;
                        pq.add(new Pair(nr,nc,nd));
                    }
                }
            }
        }
        return -1;
    }
}