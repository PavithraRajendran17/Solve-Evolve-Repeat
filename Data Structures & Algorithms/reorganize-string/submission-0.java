class Solution {
    public String reorganizeString(String s) {
         int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxFreq = 0;
        int maxChar = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = i;
            }
        }

        if(maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];
        int index = 0;

        while(freq[maxChar] > 0) {
            result[index] = (char)(maxChar + 'a');
            index += 2;
            freq[maxChar]--;
        }

        for(int i = 0; i < 26; i++) {

            while(freq[i] > 0) {

                if(index >= s.length()) {
                    index = 1;
                }

                result[index] = (char)(i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return new String(result);
        
    }
}