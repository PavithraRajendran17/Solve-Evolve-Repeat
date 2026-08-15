class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if (first == -1 || first == last) {
                continue;
            }
            boolean[] seen = new boolean[26];
            for (int i = first + 1; i < last; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }
            for (boolean x : seen) {
                if (x) {
                    ans++;
                }
            }
        }
        return ans;
    }
}