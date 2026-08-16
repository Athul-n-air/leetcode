class Solution {
    public int maximumLengthSubstring(String s) {
        int left =0;
        int ans = 0;
        int[] freq = new int[26];
        for(int right = 0; right<s.length();right++){
            int c = s.charAt(right)-'a';
            freq[c]++;
            while(freq[c]>2){
                freq[s.charAt(left)-'a']--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}