package array.reversevowels;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x93lce/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 1){
            return s;
        }
        char[] ss = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (!vowels.contains("" + s.charAt(i))){
                i++;
                continue;
            }
            if (!vowels.contains("" + s.charAt(j))){
                j--;
                continue;
            }
            char temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ss);
    }
}
