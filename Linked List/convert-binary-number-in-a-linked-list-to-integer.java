class Solution {
    public int getDecimalValue(ListNode head) {
        if(head.next == null) {
            return (head.val == 1) ? 1 : 0;
        }

        int ans = 0;
        ListNode temp = head;
        while(temp != null) {
            ans = (ans << 1);   //ans * 2
            ans += temp.val;
            temp = temp.next;
        }
        return ans;
    }
}
