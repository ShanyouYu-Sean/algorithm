package algorithm.array;

/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 */
public class FirstMissingPositive {
    // 缺失的第一个正数
    // 如果数组中包含 x in [1, N]，那么恢复后，数组的第 x-1 个元素为 x。
    // 对于遍历到的数 x = nums[i]，如果 x in [1, N]，
    // 我们就知道 x 应当出现在数组中的 x-1 的位置，
    // 因此交换 nums[i] 和 nums[x-1]
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (nums[i] > 0 && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}
