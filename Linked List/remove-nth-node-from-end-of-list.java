class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }

        ListNode slow, fast;
        slow = fast = head;

        for(int i=0; i<n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
