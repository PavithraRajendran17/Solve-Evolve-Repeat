class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        int[] result = new int[n];
        int index = 0;
        int count = 0;
        long time = 0;

        while (count < n) {
            while (index < n && arr[index][0] <= time) {
                pq.offer(arr[index]);
                index++;
            }

            if (pq.isEmpty()) {
                time = Math.max(time, arr[index][0]);
                continue;
            }

            int[] task = pq.poll();
            result[count++] = task[2];
            time += task[1];
        }

        return result;
    }
}