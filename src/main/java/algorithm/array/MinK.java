package algorithm.array;


/**
 * 最小k个数
 * 利用快排思想，写 partition 方法（与快排一致），再根据 pivotIndex 与 k 的大小比较进行递归
 */
public class MinK {

    // 最小k个数，快排思想
    public int[] getLeastNumbers(int[] arr, int k) {
        partitionArray(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i ++){
            res[i] = arr[i];
        }
        return res;
    }
    private void partitionArray(int[] nums, int startIndex, int endIndex, int k){
        if (startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(nums, startIndex, endIndex);
        if (k < pivotIndex){
            partitionArray(nums, startIndex, pivotIndex - 1, k);
        }else if (k > pivotIndex){
            partitionArray(nums, pivotIndex + 1, endIndex, k);
        }
    }
    private int partition(int[] nums, int startIndex, int endIndex){
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && nums[right] > pivot){
                right --;
            }
            while (left < right && nums[left] <= pivot){
                left ++;
            }
            if (left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[startIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }

}
