package array.palindrome;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
