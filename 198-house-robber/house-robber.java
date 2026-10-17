
import java.util.*;

class Solution {
    private int f(int ind, int[] nums, ArrayList<Integer> DP) {
        if (ind < 0) return 0;
        if (ind == 0) return nums[0];

        if (DP.get(ind) != -1) return DP.get(ind);

        int pick = nums[ind] + f(ind - 2, nums, DP);
        int not = f(ind - 1, nums, DP);

        DP.set(ind, Math.max(pick, not));

        return DP.get(ind);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        ArrayList<Integer> DP =
            new ArrayList<>(Collections.nCopies(n, -1));

        return f(n - 1, nums, DP);
    }
}
