
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            List<String> suggestions = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(prefix.toString())) {
                    suggestions.add(product);
                    if (suggestions.size() == 3) {
                        break;
                    }
                }
            }

            result.add(suggestions);
        }

        return result;
    }
}