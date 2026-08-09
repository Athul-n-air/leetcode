class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return ans;
        }

        // BFS queue
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // Distance of every word
        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 1);

        // Parents of every word
        Map<String, List<String>> parents = new HashMap<>();

        for (String word : wordList) {
            parents.put(word, new ArrayList<>());
        }

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                int step = distance.get(word);

                for (int i = 0; i < word.length(); i++) {

                    char[] chars = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        chars[i] = ch;

                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }

                        // First time visiting this word
                        if (!distance.containsKey(next)) {

                            distance.put(next, step + 1);

                            q.add(next);

                            parents.get(next).add(word);

                        }

                        // Another shortest path to next
                        else if (distance.get(next) == step + 1) {

                            parents.get(next).add(word);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
        }

        // Build all paths using DFS
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parents, path, ans);

        return ans;
    }


    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> ans) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            ans.add(temp);

            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, parents, path, ans);

            path.remove(path.size() - 1);
        }
    }
}