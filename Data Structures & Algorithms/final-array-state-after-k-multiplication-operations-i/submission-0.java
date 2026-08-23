class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] current = pq.poll();
            current[0] *= multiplier;
            nums[current[1]] = current[0];
            pq.offer(current);
        }
        return nums;
    }
}