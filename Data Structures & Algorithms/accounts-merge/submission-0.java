class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());

                if (i > 1) {
                    String first = account.get(1);
                    graph.get(first).add(email);
                    graph.get(email).add(first);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> list = new ArrayList<>();
                Stack<String> stack = new Stack<>();

                stack.push(email);
                visited.add(email);

                while (!stack.isEmpty()) {
                    String current = stack.pop();
                    list.add(current);

                    for (String next : graph.get(current)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            stack.push(next);
                        }
                    }
                }

                Collections.sort(list);
                list.add(0, emailToName.get(email));

                result.add(list);
            }
        }

        return result;
    }
}