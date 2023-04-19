package algorithm.array.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeRanges {

    // 合并区间
    // 排序之后，可以合并的区间都是连续的
    public int[][] merge(int[][] ranges){
        int n = ranges.length;
        if (n == 0){
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int[] cur = ranges[0];
        for (int i = 1; i < n; i++){
            int[] item = ranges[i];
            if (item[0] <= cur[1]){
                cur[1] = Math.max(cur[1], item[1]);
            }else {
                list.add(cur);
                cur = item;
            }
        }
        list.add(cur);
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for (int[] i : list){
            res[idx++] = i;
        }
        return res;
    }

}
