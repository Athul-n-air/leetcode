class Pair{
    int row;
    int col;
    int effort;
    Pair(int row,int col,int effort){
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[]row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.effort - b.effort);
        pq.add(new Pair(0,0,0)) ;
        dist[0][0]=0;
        int[] dc ={0,0,-1,1};
        int[] dr = {-1,1,0,0};
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            int effort = cur.effort;
            if(row ==n-1 && col == m-1)return effort;
            for(int i = 0; i<4 ;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int neweffort = Math.abs(heights[row][col]-heights[nr][nc]);
                    int maxeffort = Math.max(effort,neweffort);
                    if(maxeffort<dist[nr][nc]){
                        dist[nr][nc] = maxeffort;
                        pq.add(new Pair(nr,nc,maxeffort));
                    }
                }
            }
        }
        return 0;

    }
}