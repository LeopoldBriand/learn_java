package app.src.main.java.beginner;

public class PalindromeChecker {

    public static void main(String[] args) {
        if (checker(args[0])) {
            System.out.println(args[0] + " is a palindrome");
        } else {
            System.out.println(args[0] + " is not a palindrome");
        }

    }

    private static boolean checker(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < (chars.length - 1) / 2; i++) {
            if (!(chars[i] == chars[chars.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

}