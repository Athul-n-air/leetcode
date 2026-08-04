class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        List<Integer> ans = new ArrayList<>();
        int a =0;
        for(int i=min;i<nums[nums.length-1];i++){
            if(nums[a]==i){
                a++;
            }else{
                ans.add(i);
            }
        }
        return ans;
    }
}