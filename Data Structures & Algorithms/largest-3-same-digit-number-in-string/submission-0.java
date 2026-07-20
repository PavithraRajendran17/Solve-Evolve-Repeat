class Solution {
    public String largestGoodInteger(String num) {
        char max = ' ';
        for (int i = 0; i <= num.length() - 3; i++) {
            char ch = num.charAt(i);
            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {
                if (max == ' ' || ch > max) {
                    max = ch;
                }
            }
        }
        if (max == ' ') {
            return "";
        }
        return "" + max + max + max;
    }
}