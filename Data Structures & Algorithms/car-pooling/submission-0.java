class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }

        int passengers = 0;

        for (int i = 0; i < 1001; i++) {
            passengers += arr[i];

            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}