package algorithm.array;

/**
 * 盛最多水的容器
 * 数组左右最大边界决定
 */
public class MaxWaterArea {

    // 盛最多水的容器
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
