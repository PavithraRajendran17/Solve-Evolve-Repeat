class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        head = reverse(head);
        int max = 0;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val >= max) {
                max = curr.val;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}