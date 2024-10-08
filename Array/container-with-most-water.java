class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(n == 2) {
            return Math.min(height[0], height[1]);
        }

        int area = 0, i = 0, j = n-1;
        while(i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j-i));

            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }

        return area;
    }
}