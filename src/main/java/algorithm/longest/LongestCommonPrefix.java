package algorithm.longest;

/**
 * 查找字符串数组中的最长公共前缀
 * 转化为寻找两个字符串的公共前缀，然后用这个前缀跟下个字符串做比较
 */
public class LongestCommonPrefix {

    // 查找字符串数组中的最长公共前缀
    // 转化为寻找两个字符串的公共前缀，然后用这个前缀跟下个字符串做比较
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String s = compare(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++){
            s = compare(s, strs[i]);
        }
        return s;
    }
    public String compare(String str1, String str2){
        if ("".equals(str1) || "".equals(str2)){
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        int tempLength = Math.min(str1.length(), str2.length());
        for (int j = 0; j < tempLength; j++){
            if (str1.toCharArray()[j] == str2.toCharArray()[j]){
                commonPrefix.append(str1.toCharArray()[j]);
            }else {
                return commonPrefix.toString();
            }
        }
        return commonPrefix.toString();
    }
}
