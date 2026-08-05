class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakePairs(nums, p, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMakePairs(int[] nums, int p, int maxDiff) {
        int pairs = 0;

        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i += 2; 
            } else {
                i++;
            }
        }

        return pairs >= p;
    }
}