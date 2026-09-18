class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n  =  nums1.length;
        int a = 0;
        int[] ans = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums1){
            set.add(val);
        }
        for(int val: nums2){
            if(set.contains(val)){
                ans[a] = val;
                a++;
                set.remove(val);
            }
        }
        return Arrays.copyOf(ans,a);
    }
}