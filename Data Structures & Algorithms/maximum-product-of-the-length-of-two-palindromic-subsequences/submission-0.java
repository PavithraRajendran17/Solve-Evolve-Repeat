class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 1; i < (1 << n); i++) {
            StringBuilder a = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    a.append(s.charAt(j));
                }
            }

            if (!isPalindrome(a.toString())) {
                continue;
            }

            for (int k = 1; k < (1 << n); k++) {
                if ((i & k) == 0) {
                    StringBuilder b = new StringBuilder();

                    for (int j = 0; j < n; j++) {
                        if ((k & (1 << j)) != 0) {
                            b.append(s.charAt(j));
                        }
                    }

                    if (isPalindrome(b.toString())) {
                        max = Math.max(max, a.length() * b.length());
                    }
                }
            }
        }

        return max;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}