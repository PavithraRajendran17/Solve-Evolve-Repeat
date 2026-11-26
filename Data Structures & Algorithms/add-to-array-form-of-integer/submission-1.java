class Solution {
    public int[] addToArrayForm(int[] num, int k) {
        int[] result = new int[num.length + 5];
        int i = num.length - 1;
        int j = result.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }

            result[j] = k % 10;
            k /= 10;
            j--;
        }

        while (i >= 0) {
            result[j] = num[i];
            i--;
            j--;
        }

        int[] ans = new int[result.length - j - 1];

        for (int p = 0; p < ans.length; p++) {
            ans[p] = result[j + 1 + p];
        }

        return ans;
    }
}