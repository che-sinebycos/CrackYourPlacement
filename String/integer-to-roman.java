class Solution { 
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(num > 0) {
            while(num >= nums[i]) {
                num -= nums[i];
                res.append(chars[i]);
            }
            i++;
        }
        
        return res.toString();
    }
}
