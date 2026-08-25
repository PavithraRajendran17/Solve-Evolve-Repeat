class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (int freq : map.values()) {
            if (freq == 1) {
                return -1;
            }
            operations += freq / 3;
            if (freq % 3 != 0) {
                operations++;
            }
        }
        return operations;
    }
}