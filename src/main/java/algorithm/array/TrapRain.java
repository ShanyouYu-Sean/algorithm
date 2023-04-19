package algorithm.array;

/**
 * 接雨水
 * 双指针，左右边界最大值比较，
 * 左边有低于左边最大值的时候，即形成低洼，可以接雨水，右边同理
 */
public class TrapRain {

    // 接雨水
    // 双指针，左右边界最大值比较，左边有低于左边最大值的时候，即形成低洼，可以接雨水
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] >= leftMax){
                    // 更新左边最大值
                    leftMax = height[left];
                }else {
                    // 低洼处接雨水
                    res += (leftMax - height[left]);
                }
                left ++;
            }else {
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }else {
                    res += (rightMax - height[right]);
                }
                right --;
            }
        }
        return res;
    }

}
