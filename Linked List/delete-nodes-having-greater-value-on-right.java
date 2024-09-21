class Solution {
    Node compute(Node head) {
        if(head.next == null) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        Node reverseHead = prev;
        
        int maxData = -1;
        while(prev != null) {
            if(prev.data >= maxData) {
                maxData = prev.data;
                curr = prev;
            }
            else if(prev.data < maxData) {
                curr.next = prev.next;
            }
            prev = prev.next;
        }
        
        prev = null;
        curr = reverseHead;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}
