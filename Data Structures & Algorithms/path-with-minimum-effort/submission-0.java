class Solution {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        pq.add(new int[]{0, 0, 0});

        effort[0][0] = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int row = current[0];
            int col = current[1];
            int currentEffort = current[2];

            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            }

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    int difference = Math.abs(
                        heights[row][col] -
                        heights[newRow][newCol]
                    );

                    int newEffort = Math.max(
                        currentEffort,
                        difference
                    );

                    if (newEffort < effort[newRow][newCol]) {

                        effort[newRow][newCol] = newEffort;

                        pq.add(new int[]{
                            newRow,
                            newCol,
                            newEffort
                        });
                    }
                }
            }
        }

        return 0;
    }
}