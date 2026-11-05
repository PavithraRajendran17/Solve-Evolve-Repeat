class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int f : freq) {
            while (f > 0 && set.contains(f)) {
                f--;
                ans++;
            }

            if (f > 0) {
                set.add(f);
            }
        }

        return ans;
    }
}