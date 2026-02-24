import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * MAIN CLASS UseCase6PalindromeCheckerApp (Integrated into Main)
 * Use Case 6: Queue Stack Fairness Check
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 * Queue (FIFO First In First Out)
 * Stack (LIFO Last In First Out)
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 * If all characters match, the input string is confirmed as a palindrome.
 */
public class Main {

    public static void main(String[] args) {
        // --- PREVIOUS UCs LOGIC ---
        System.out.println("hello to the palindrome checker management system\nVersion : 1.0\nSystem initialized successfully.");

        String input = "madaw";
        String reversed = "";
        int palindrome = 0;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) == input.charAt(input.length() - 1)) {
                palindrome += 1;
            }
        }
        System.out.println("Is it a palindrome? : " + (palindrome != 0));

        System.out.println("-----------------------UC3-------------------");
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Is it a palindrome? : " + reversed.equals(input));

        System.out.println("------------------------------UC4---------------------------");
        String input1 = "radar";
        char[] chars = input1.toCharArray();
        int start = 0, end = chars.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("Input String: " + input1 + "\nResult: " + isPalindrome);

        System.out.println("----------------------------UC5-------------------------------");
        String input2 = "noon";
        Stack<Character> stackUC5 = new Stack<>();
        for (char c : input2.toCharArray()) stackUC5.push(c);
        isPalindrome = true;
        for (char c : input2.toCharArray()) {
            if (c != stackUC5.pop()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Input String: " + input2 + "\nResult: " + isPalindrome);

        // --- UC6 START ---
        System.out.println("----------------------------UC6-------------------------------");

        // Define the input string to validate
        String inputUC6 = "civic";

        // Create a Queue to store characters in FIFO order
        Queue<Character> queueUC6 = new LinkedList<>();

        // Create a Stack to store characters in LIFO order
        Stack<Character> stackUC6 = new Stack<>();

        // Insert each character into both queue and stack
        for (char c : inputUC6.toCharArray()) {
            queueUC6.add(c);     // Enqueue (FIFO)
            stackUC6.push(c);    // Push (LIFO)
        }

        // Flag to track palindrome status
        boolean isPalindromeUC6 = true;

        // Compare characters until the queue becomes empty
        while (!queueUC6.isEmpty()) {
            // dequeue (gets first char) vs pop (gets last char)
            if (!queueUC6.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        // Output results to console
        System.out.println("Input: " + inputUC6);
        System.out.println("Is Palindrome?: " + isPalindromeUC6);
        // --- UC6 END ---
    }
}