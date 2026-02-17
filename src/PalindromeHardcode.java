public class PalindromeHardcode {
    public boolean hardcodePaliCheck(String input) {
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                return false;  // not a palindrome
            }
        }
        return true;  // palindrome

    }
}

