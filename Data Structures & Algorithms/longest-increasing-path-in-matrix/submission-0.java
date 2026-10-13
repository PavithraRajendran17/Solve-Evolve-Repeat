class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, dp, i, j));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int length = 1;

        for (int d = 0; d < 4; d++) {
            int r = i + dr[d];
            int c = j + dc[d];

            if (r >= 0 && r < m && c >= 0 && c < n
                    && matrix[r][c] > matrix[i][j]) {
                length = Math.max(length, 1 + dfs(matrix, dp, r, c));
            }
        }

        dp[i][j] = length;
        return length;
    }
}