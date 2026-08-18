class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            String s,
            int index,
            List<String> parts,
            List<String> result) {

        // If we have 4 parts
        if (parts.size() == 4) {

            // All digits must be used
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }

            return;
        }

        // Try 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Value must be <= 255
            if (Integer.parseInt(part) > 255) {
                break;
            }

            // Choose
            parts.add(part);

            // Explore
            backtrack(
                s,
                index + len,
                parts,
                result
            );

            // Undo
            parts.remove(parts.size() - 1);
        }
    }
}