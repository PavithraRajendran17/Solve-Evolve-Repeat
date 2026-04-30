class Solution {
    public int countCharacters(String[] words, String chars) {
        int total = 0;
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean valid = true;
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
                if (wordCount[c - 'a'] > charCount[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                total += word.length();
            }
        }
        return total;
    }
}