package array.maxarea;

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x96n4v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            if (height[i] > height[j]){
                int temp = (j-i) * height[j];
                result = Math.max(result, temp);
                j--;
            }else {
                int temp = (j-i) * height[i];
                result = Math.max(result, temp);
                i++;
            }
        }
        return result;
    }
}
