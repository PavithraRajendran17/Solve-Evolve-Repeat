class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Stack<Integer> stack = new Stack<>();

        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && directions.charAt(stack.peek()) == 'R' && healths[idx] > 0) {
                    int top = stack.peek();

                    if (healths[top] < healths[idx]) {
                        healths[top] = 0;
                        stack.pop();
                        healths[idx]--;
                    } else if (healths[top] == healths[idx]) {
                        healths[top] = 0;
                        healths[idx] = 0;
                        stack.pop();
                    } else {
                        healths[top]--;
                        healths[idx] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                ans.add(healths[i]);
            }
        }

        return ans;
    }
}