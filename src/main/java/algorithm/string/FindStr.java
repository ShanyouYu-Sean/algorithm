package algorithm.string;

/**
 * 字符串匹配
 * 滑窗
 */
public class FindStr {

    // 字符串匹配
    // 滑窗
    public static int strStr(String haystack, String needle) {
        //构建长度与needle相等的滑动窗口
        int left = 0, right = needle.length() - 1;
        //不断移动滑动窗口，窗口的子串与目标子串进行匹配
        while (right <= haystack.length() - 1) {
            if (haystack.substring(left, right + 1).equals(needle)){
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }
}
