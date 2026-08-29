class Solution {
    public String removeDuplicates(String s, int k) {
        char[] stack = new char[s.length()];
        int[] count = new int[s.length()];
        int top = -1;
        for (char ch : s.toCharArray()) {
            if (top >= 0 && stack[top] == ch) {
                count[top]++;
                if (count[top] == k) {
                    top--;
                }
            } else {
                top++;
                stack[top] = ch;
                count[top] = 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.append(stack[i]);
            }
        }
        return result.toString();
    }
}