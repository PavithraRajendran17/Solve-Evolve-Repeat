class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for (int[] query : q) {

            int value = query[0];

            while (i < intervals.length && intervals[i][0] <= value) {

                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                pq.offer(new int[]{length, right});

                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < value) {
                pq.poll();
            }

            if (pq.isEmpty()) {
                result[query[1]] = -1;
            } else {
                result[query[1]] = pq.peek()[0];
            }
        }

        return result;
        
    }
}
