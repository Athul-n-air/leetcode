class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : invocations)
            adj.get(edge[0]).add(edge[1]);

        boolean[] suspicious = new boolean[n];

        dfs(k, adj, suspicious);

        // Check if any safe node calls a suspicious node
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        // Remove suspicious nodes
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.add(i);
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : adj.get(node)) {
            if (!suspicious[next])
                dfs(next, adj, suspicious);
        }
    }
}