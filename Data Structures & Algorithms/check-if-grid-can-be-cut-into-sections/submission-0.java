class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (check(rectangles, 0)) {
            return true;
        }

        return check(rectangles, 1);
    }

    public boolean check(int[][] rectangles, int axis) {
        Arrays.sort(rectangles, (a, b) -> a[axis] - b[axis]);

        int count = 0;
        int end = rectangles[0][axis + 2];

        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][axis] >= end) {
                count++;
            }

            end = Math.max(end, rectangles[i][axis + 2]);
        }

        return count >= 2;
    }
}