class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        minDist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            int u = -1;

            int min = Integer.MAX_VALUE;

            // Find minimum distance unvisited point
            for (int i = 0; i < n; i++) {

                if (!visited[i] && minDist[i] < min) {

                    min = minDist[i];

                    u = i;
                }
            }
            visited[u] = true;

            totalCost += minDist[u];
            for (int v = 0; v < n; v++) {

                if (!visited[v]) {

                    int distance =
                        Math.abs(points[u][0] - points[v][0])
                        + Math.abs(points[u][1] - points[v][1]);

                    if (distance < minDist[v]) {

                        minDist[v] = distance;
                    }
                }
            }
        }

        return totalCost;
    }
}