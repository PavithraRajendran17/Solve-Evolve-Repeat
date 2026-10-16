class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = sb.length();

            if (n > 0 && Math.abs(sb.charAt(n - 1) - c) == 32) {
                sb.deleteCharAt(n - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}