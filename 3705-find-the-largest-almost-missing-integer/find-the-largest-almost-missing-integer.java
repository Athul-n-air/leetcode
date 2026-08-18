class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for (int x : nums) freq[x]++;

        int ans = -1;

        if (k == n) {
            for (int x : nums) ans = Math.max(ans, x);
        } else if (k == 1) {
            for (int x : nums) {
                if (freq[x] == 1) ans = Math.max(ans, x);
            }
        } else {
            if (freq[nums[0]] == 1)     ans = Math.max(ans, nums[0]);
            if (freq[nums[n - 1]] == 1) ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}