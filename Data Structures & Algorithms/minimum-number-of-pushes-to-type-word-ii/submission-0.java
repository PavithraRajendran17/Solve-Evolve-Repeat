class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int total = 0;

        for (int i = 25; i >= 0; i--) {
            int pushes = (25 - i) / 8 + 1;
            total += freq[i] * pushes;
        }

        return total;
    }
}