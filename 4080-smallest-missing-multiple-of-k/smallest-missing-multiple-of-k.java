class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<nums.length;i++){
            s.add(nums[i]);
        }
        for(int i = 1;i<102;i++){
            int m = i*k;
            if(!s.contains(m)){
                return m;
            }
        }
        return k;
    }
}