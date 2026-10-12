class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, TreeMap<Integer, String>> users = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            users.putIfAbsent(username[i], new TreeMap<>());
            users.get(username[i]).put(timestamp[i], website[i]);
        }

        Map<String, Integer> count = new HashMap<>();

        for (String user : users.keySet()) {
            List<String> sites = new ArrayList<>(users.get(user).values());
            Set<String> patterns = new HashSet<>();

            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        patterns.add(pattern);
                    }
                }
            }

            for (String pattern : patterns) {
                count.put(pattern, count.getOrDefault(pattern, 0) + 1);
            }
        }

        String best = "";
        int maxCount = 0;

        for (String pattern : count.keySet()) {
            int current = count.get(pattern);

            if (current > maxCount || (current == maxCount && pattern.compareTo(best) < 0)) {
                maxCount = current;
                best = pattern;
            }
        }

        return Arrays.asList(best.split(","));
    }
}