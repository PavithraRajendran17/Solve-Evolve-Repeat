
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] indices = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            long x = mappedValue(nums[a], mapping);
            long y = mappedValue(nums[b], mapping);
            return Long.compare(x, y);
        });

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[indices[i]];
        }

        return result;
    }

    private long mappedValue(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }

        long result = 0;
        long place = 1;

        while (num > 0) {
            result += (long) mapping[num % 10] * place;
            place *= 10;
            num /= 10;
        }

        return result;
    }
}