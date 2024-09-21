class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long firstNum = 0, secondNum = 0;
        long mod = 1000000007;
        while(first != null) {
            firstNum = ((firstNum * 10L) + first.data) % mod;
            first = first.next;
        }
        while(second != null) {
            secondNum = ((secondNum * 10L) + second.data) % mod;
            second = second.next;
        }
        
        return ((firstNum % mod) * (secondNum % mod)) % mod;
    }
}
