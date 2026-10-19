class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return solve(expression, memo);
    }

    private List<Integer> solve(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solve(expression.substring(0, i), memo);
                List<Integer> right = solve(expression.substring(i + 1), memo);

                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            result.add(a + b);
                        } else if (c == '-') {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}