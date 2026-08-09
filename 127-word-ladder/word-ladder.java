class Pair{
    String first;
    int second; 
    Pair(String first,int second){
        this.first =first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<String>();
        for(int i = 0; i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();
            if(word.equals(endWord))return step;
            for(int i = 0; i<word.length();i++){
                for(char ch ='a' ;ch<='z';ch++){
                    char[] rep = word.toCharArray();
                    rep[i] = ch;
                    String replacement = new String(rep);
                    if(st.contains(replacement)){
                        st.remove(replacement);
                        q.add(new Pair(replacement,step+1));
                    }
                }
            }
        }
        return 0;
    }
}