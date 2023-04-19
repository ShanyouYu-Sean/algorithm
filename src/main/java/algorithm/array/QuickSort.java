package algorithm.array;


/**
 * 快排
 * 最左端为 pivot 基准值, while 循环嵌套, 先比较 right, 再比较 left, 然后交换 left 和 right, 最后循环外交换 start 和 left
 */
public class QuickSort {

    // 快排
    public static void quickSort(int[] arr, int startIndex, int endIndex){
        // 递归结束条件: startIndex >= endIndex
        if (startIndex >= endIndex){
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素, 分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex -1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }
    /**
     * 分治 (双边循环法)
     * @param arr 待交换的数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return 返回基准元素位置
     */
    private static int partition(int[] arr, int startIndex, int endIndex){
        // 取第1个位置 (也可以选择随机位置) 的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            // 控制 right 指针比较并左移
            while (left < right && arr[right] > pivot){
                right --;
            }
            // 控制 left 指针比较并右移
            while (left < right && arr[left] <= pivot){
                left ++;
            }
            // 交换 left 和 right 指针所指向的元素
            if (left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

}
