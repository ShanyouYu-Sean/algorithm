package array.sortcolors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？

 作者：力扣 (LeetCode)
 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9wv2h/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (i < count0){
                nums[i] = 0;
            }else if (i < count0 + count1){
                nums[i] = 1;
            }else if (i < count0 + count1 + count2){
                nums[i] = 2;
            }
        }
    }
    public void partitionSortColors(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int p0 = 0;
        int p1 = nums.length - 1;
        int i = 0;
        while (i <= p1){
            if (nums[i] == 0){
                swap(nums, p0, i);
                p0 ++;
                i ++;
            }else if (nums[i] == 1){
                i ++;
            }else if (nums[i] == 2){
                swap(nums, i, p1);
                p1 --;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
