class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int side = sum / 4;
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, side);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int side) {
        if (index == matchsticks.length) {
            return sides[0] == side &&
                   sides[1] == side &&
                   sides[2] == side &&
                   sides[3] == side;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= side) {
                sides[i] += stick;

                if (backtrack(matchsticks, index + 1, sides, side)) {
                    return true;
                }

                sides[i] -= stick;
            }
        }

        return false;
    }
}