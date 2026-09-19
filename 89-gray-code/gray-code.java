class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1<<n;
        ArrayList<Integer> ans  = new ArrayList<>(size);
        for(int i =0;i<size;i++){
            int gray  = i^(i>>1);
            ans.add(gray);
        }
        return ans;
    }
}