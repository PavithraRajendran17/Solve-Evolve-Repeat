class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] arr : nums1) {
            map.put(arr[0], arr[1]);
        }

        for (int[] arr : nums2) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }

        int[][] result = new int[map.size()][2];
        int i = 0;

        for (int id : map.keySet()) {
            result[i][0] = id;
            result[i][1] = map.get(id);
            i++;
        }

        return result;
    }
}