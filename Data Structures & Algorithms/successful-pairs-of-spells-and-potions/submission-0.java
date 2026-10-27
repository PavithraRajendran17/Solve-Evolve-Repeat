class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = n - 1;
            int index = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if ((long) spells[i] * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = n - index;
        }

        return answer;
    }
}