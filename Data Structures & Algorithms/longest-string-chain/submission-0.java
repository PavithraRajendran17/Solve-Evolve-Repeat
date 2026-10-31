class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashMap<String, Integer> map = new HashMap<>();
        int ans = 1;

        for (String word : words) {
            int max = 1;

            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);

                max = Math.max(max, map.getOrDefault(prev, 0) + 1);
            }

            map.put(word, max);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}