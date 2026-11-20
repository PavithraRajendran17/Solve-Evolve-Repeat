
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        if (isAnagram(count)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {

            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - p.length()) - 'a']++;

            if (isAnagram(count)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public boolean isAnagram(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}