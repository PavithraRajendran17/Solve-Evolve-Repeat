class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }

        int[] result = new int[deck.length];

        for (int card : deck) {
            result[q.poll()] = card;

            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        return result;
    }
}