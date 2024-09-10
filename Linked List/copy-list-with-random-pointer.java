class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        Node p = head;
        while(p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        p = head;
        while(p != null) {
            if(p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        Node newHead = p.next;
        Node temp = newHead;
        while(p != null) {
            p.next = temp.next;
            p = p.next;
            if(p != null) {
                temp.next = p.next;
            }
            temp = temp.next;
        }

        return newHead;
    }
}
