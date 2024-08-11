class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if(n > h) {
            return -1;
        }

        int[] lps = new int[n];
        int pre = 0, suf = 1;
        while(suf < n) {
            if(needle.charAt(pre) == needle.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            }
            else {
                if(pre == 0) {
                    lps[suf] = 0;
                    suf++;
                }
                else {
                    pre = lps[pre-1];
                }
            }
        }

        pre = suf = 0;
        while(pre < h && suf < n) {
            if(haystack.charAt(pre) == needle.charAt(suf)) {
                pre++;
                suf++;
            }
            else {
                if(suf == 0) {
                    pre++;
                }
                else {
                    suf = lps[suf-1];
                }
            }
        }
        return (suf == n) ? (pre - suf) : -1;
    }
}
