class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();

        // Find dominant element
        int dominant = nums.get(0);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                dominant = nums.get(i);
                count = 1;
            }
        }

        // Count total occurrences of dominant element
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                totalCount++;
            }
        }

        // Check every possible split
        int leftCount = 0;

        for (int i = 0; i < n - 1; i++) {

            if (nums.get(i) == dominant) {
                leftCount++;
            }

            int leftLength = i + 1;
            int rightLength = n - leftLength;
            int rightCount = totalCount - leftCount;

            if (leftCount * 2 > leftLength &&
                rightCount * 2 > rightLength) {

                return i;
            }
        }

        return -1;
    }
}