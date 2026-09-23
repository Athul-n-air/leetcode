class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int left =0;
        int n = s.length();
        int m = p.length();
        int right =m;
        char[] check = p.toCharArray();
        Arrays.sort(check);
        while(right<=n){
           String win = s.substring(left,right);
            char[] window = win.toCharArray();
            Arrays.sort(window);
            if(Arrays.equals(window,check)){
                result.add(left);
            }
            left++;
            right++;
        }
        return result;

    }
}