class Solution {
    public int trap(int[] heights) {
        if (heights.length == 0) {
        return 0;
    }
    int left = 0, right = heights.length - 1;
    int leftMax = heights[left], rightMax = heights[right];
    int count = 0;
    
    while (left < right) {
        if (leftMax < rightMax) {
            left++;
            if (heights[left] >= leftMax) {
                leftMax = heights[left];
            } else {
                count += leftMax - heights[left];
            }
        } else {
            right--;
            if (heights[right] >= rightMax) {
                rightMax = heights[right];
            } else {
                count += rightMax - heights[right];
            }
        }
    }
    
    return count;
    }
}