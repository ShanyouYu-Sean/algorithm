package algorithm.half;

public class ArraysMid {

    // 寻找两个正序数组的中位数
    // 因为中位数左右两边元素个数是一样的，m = nums1.length, n= nums2.length, k=m+n,
    // 那么中位数左右两边元素个数都是k/2，
    // 如果nums1在中位数的左边有i个元素，那么nums2在中位数的左边就有j = k/2-i个元素。
    // i和j将两个数组分成了左右两部分，这时要满足的条件
    // - nums1左部的最大值小于nums2右部的最小值
    // - nums2左部的最大值小于nums1右部的最小值
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 这个地方要保证nums1的长度不能比nums2大,否则j可能会小于0
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // 要使用二分查找，就是每次要去掉一半的数据，因为我们是要改变i的值，那么i的值就在[0,m]这个区间，
        // 第一次i=m/2，如果i的值大了，那么第二次查找区间就变成[0,m1]，这个m1就等于第一次的i,依次类推
        int iMin = 0;
        int iMax = m;
        while (true) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i > iMin && nums1[i - 1] > nums2[j]) { // 如果i大了，就向左找
                iMax = i - 1;
            } else if (i < iMax && nums2[j - 1] > nums1[i]) { //i小了就向右找
                iMin = i + 1;
            } else {
                // 如果一共有奇数个元素，那么中位数就是左侧最大的那个
                // 左侧最大的那个就是Math.max(nums1[i - 1], nums2[j - 1])
                // 但i和j为0的时候要特殊考虑
                int leftMax = 0;
                int rightMin = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                // 如果一共有偶数个元素
                // 正常情况下rightMin = Math.min(nums1[i], nums2[j])
                // median = (leftMax + rightMin) / 2.0
                // i=m,j=n时，rightMin是不对的，所以又要处理边界
                if (i == m) {
                    rightMin = nums2[j];
                }else if(j == n) {
                    rightMin = nums1[i];
                }else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                if ((m + n) % 2 == 0) {
                    return (leftMax + rightMin) / 2.0;
                }
            }
        }
    }

}
