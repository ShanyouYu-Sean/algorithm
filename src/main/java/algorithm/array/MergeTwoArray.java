package algorithm.array;

/**
 * 合并有序数组
 * 三指针
 * 指针一 p1、nums1 有效元素尾部
 * 指针二 p2、nums2 尾部
 * 指针三 p3、最终数组尾部
 * 1、当 p1 >= 0 时，nums[p1]、nums[p2] 对比
 * 1.1、nums[p1] > nums[p2]，将 nums[p1] 放入 p3 位置，p1--，p3--
 * 1.2、nums[p1] <= nums[p2]，将 nums[p2] 放入 p3 位置，p2--，p3--
 * 2、当 p1 < 0 时，将 nums[p2] 放入 p3 位置，p2--，p3--
 * 循环结束条件：p2 < 0
 */
public class MergeTwoArray {

    // 合并有序数组
    // 三指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p2 >= 0){
            if (p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            }else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }
}
