class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = 0;

            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                count += i - j;
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}