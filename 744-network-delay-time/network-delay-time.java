class Solution {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[k] = 0;
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int d = cur.dist;
            if (d > dist[node])
                continue;
            for (int[] edge : times) {
                if (edge[0] != node)
                    continue;
                int next = edge[1];
                int w = edge[2];
                if (d + w < dist[next]) {
                    dist[next] = d + w;
                    pq.offer(new Pair(next, dist[next]));
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }
        return max;
    }
}