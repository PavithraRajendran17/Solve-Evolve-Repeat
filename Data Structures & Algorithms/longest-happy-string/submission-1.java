class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();
        while (a + b + c > 0) {
            if (a >= b && a >= c && !(s.length() >= 2 && s.charAt(s.length() - 1) == 'a' && s.charAt(s.length() - 2) == 'a')) {
                s.append('a');
                a--;
            } else if (b >= a && b >= c && !(s.length() >= 2 && s.charAt(s.length() - 1) == 'b' && s.charAt(s.length() - 2) == 'b')) {
                s.append('b');
                b--;
            } else if (c > 0 && !(s.length() >= 2 && s.charAt(s.length() - 1) == 'c' && s.charAt(s.length() - 2) == 'c')) {
                s.append('c');
                c--;
            } else {
                if (a > 0 && s.charAt(s.length() - 1) != 'a') {
                    s.append('a');
                    a--;
                } else if (b > 0 && s.charAt(s.length() - 1) != 'b') {
                    s.append('b');
                    b--;
                } else if (c > 0 && s.charAt(s.length() - 1) != 'c') {
                    s.append('c');
                    c--;
                } else {
                    break;
                }
            }
        }

        return s.toString();
        
    }
}