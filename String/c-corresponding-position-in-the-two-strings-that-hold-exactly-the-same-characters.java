class Solution { 
    boolean isSame(char a, char b) {
        if(a >= 'A' && a <= 'Z') {
            a += 32;
        }
        if(b >= 'A' && b <= 'Z') {
            b += 32;
        }
        return (a == b);
    }
    
    int sameChar(String A, String B) {
        int m = A.length();
        int n = B.length();
        if(m == 1) {
            return (isSame(A.charAt(0), B.charAt(0))) ? 1 : 0;
        }
        int i=0, ans=0;
        
        while(i < m) {
            if(isSame(A.charAt(i), B.charAt(i))) {
                ans++;
            }
            i++;
        }
        return ans;
    }
}
