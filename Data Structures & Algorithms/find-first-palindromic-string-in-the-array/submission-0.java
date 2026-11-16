class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();

            if (word.equals(rev)) {
                return word;
            }
        }

        return "";
    }
}