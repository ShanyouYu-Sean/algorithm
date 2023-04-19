package algorithm.string;

public class AddTwoString {

    // string 大数相加
    public String addTwoNumbers(String s1, String s2){
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0){
            int a = 0, b = 0;
            if (i >= 0){
                a = Integer.parseInt(String.valueOf(s1.charAt(i)));
            }
            if (j >= 0){
                b = Integer.parseInt(String.valueOf(s2.charAt(j)));
            }
            int c = (a + b + carry)%10;
            carry = (a + b + carry)/10;
            res.append(c);
            i --;
            j --;
        }
        if (carry != 0){
            res.append(carry);
        }
        // 反转
        res.reverse();
        return res.toString();
    }

}
