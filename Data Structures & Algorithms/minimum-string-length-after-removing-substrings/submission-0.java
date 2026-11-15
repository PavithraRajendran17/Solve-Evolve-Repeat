class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = sb.length();

            if (n > 0 && ((sb.charAt(n - 1) == 'A' && c == 'B') ||
                          (sb.charAt(n - 1) == 'C' && c == 'D'))) {
                sb.deleteCharAt(n - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.length();
    }
}