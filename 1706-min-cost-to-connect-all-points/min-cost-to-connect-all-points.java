class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] mindist = new int[n];
        Arrays.fill(mindist,Integer.MAX_VALUE);
        boolean[] intree = new boolean[n];

        mindist[0]= 0;
        int total =0;
        for(int step = 0; step<n;step++){
            int  u  = - 1;
            for(int v = 0; v<n;v++){
                if(!intree[v] && (u==-1||mindist[v]<mindist[u])){
                    u=v;
                }
            }
            intree[u]=true;
            total +=mindist[u];
            for(int v = 0 ; v<n ; v++){
                if(!intree[v]){
                int d = Math.abs(points[u][0]-points[v][0])+ Math.abs(points[u][1]-points[v][1]);
                if(d<mindist[v]){
                    mindist[v] = d;
                }
            }
            }
        }
        return total;
    }
}