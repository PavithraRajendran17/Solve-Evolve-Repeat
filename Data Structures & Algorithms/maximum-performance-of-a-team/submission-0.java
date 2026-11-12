class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long max = 0;
        int mod = 1000000007;

        for (int[] engineer : engineers) {
            int eff = engineer[0];
            int sp = engineer[1];

            pq.offer(sp);
            sum += sp;

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            max = Math.max(max, sum * eff);
        }

        return (int) (max % mod);
    }
}