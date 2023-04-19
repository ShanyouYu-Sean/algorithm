package algorithm.longest;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 * 遍历, 中心扩散, 注意有单双数, 多亿要扩散 i 和 i + 1
 */
public class LongestPalindrome {

    // 最长回文子串
    // 遍历, 中心扩散, 注意有单双数, 要扩散 i 和 i + 1
    public String longestPalindrome(String s) {
        int begin = 0;
        int size = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            Map<String, Integer> tmp1 = palindrome(sArray, i, i);
            Map<String, Integer> tmp2 = palindrome(sArray, i, i + 1);
            int tmpSize, tmpBegin;
            if (tmp1.get("size") > tmp2.get("size")){
                tmpSize = tmp1.get("size");
                tmpBegin = tmp1.get("begin");
            }else {
                tmpSize = tmp2.get("size");
                tmpBegin = tmp2.get("begin");
            }
            if (tmpSize > size){
                size = tmpSize;
                begin = tmpBegin;
            }
        }
        return s.substring(begin, begin + size -1);
    }
    Map<String, Integer> palindrome(char[] s, int i, int j){
        while (i >= 0 && j < s.length && s[i] == s[j]){
            j --;
            i ++;
        }
        Map<String, Integer> tmp = new HashMap<>();
        tmp.put("begin", i + 1);
        tmp.put("size", j - 1);
        return tmp;
    }

}
