class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>());

        int i = 0;

        while (i < formula.length()) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } 
            else if (ch == ')') {
                Map<String, Integer> group = stack.pop();
                i++;

                int num = 0;

                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (num == 0) {
                    num = 1;
                }

                for (String element : group.keySet()) {
                    int count = group.get(element) * num;
                    Map<String, Integer> top = stack.peek();
                    top.put(element, top.getOrDefault(element, 0) + count);
                }
            } 
            else {
                String element = "";

                element += formula.charAt(i);
                i++;

                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    element += formula.charAt(i);
                    i++;
                }

                int num = 0;

                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (num == 0) {
                    num = 1;
                }

                Map<String, Integer> top = stack.peek();
                top.put(element, top.getOrDefault(element, 0) + num);
            }
        }

        map.putAll(stack.pop());

        StringBuilder result = new StringBuilder();

        for (String element : map.keySet()) {
            result.append(element);

            if (map.get(element) > 1) {
                result.append(map.get(element));
            }
        }

        return result.toString();
    }
}