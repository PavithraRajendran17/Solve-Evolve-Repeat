
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, (long) lower - 1);
    }

    private long count(int[] nums, long target) {
        long pairs = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ((long) nums[left] + nums[right] <= target) {
                pairs += right - left;
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
}