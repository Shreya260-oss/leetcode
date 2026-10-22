
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;

        // Check whether k nodes are available
        while (count < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            count++;
        }

        // Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the remaining groups
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
