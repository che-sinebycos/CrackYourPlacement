class Solution {
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            temp.next = l1;
        }
        else if(l2 != null) {
            temp.next = l2;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow, fast;
        slow = fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        slow = sortList(slow);
        fast = sortList(fast);
        return mergeTwoSortedLists(slow, fast);
    }
}
