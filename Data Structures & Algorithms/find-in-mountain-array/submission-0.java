class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peak = low;

        low = 0;
        high = peak;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = peak + 1;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } else if (value > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}