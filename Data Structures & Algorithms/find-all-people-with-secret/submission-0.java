class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;

        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int a = meetings[i][0];
                int b = meetings[i][1];

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());

                graph.get(a).add(b);
                graph.get(b).add(a);

                people.add(a);
                people.add(b);
                i++;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int person : people) {
                if (knows[person]) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            while (!queue.isEmpty()) {
                int person = queue.poll();

                for (int next : graph.get(person)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        knows[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (knows[j]) {
                ans.add(j);
            }
        }

        return ans;
    }
}