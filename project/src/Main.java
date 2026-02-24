import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello to the palindrome checker management system\nVersion : 1.0\nSystem initialized successfully.");

        String input = "madaw";
        String reversed = "";
        int palindrome = 0;

        // --- UC1/UC2 ---
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) == input.charAt(input.length() - 1)) {
                palindrome += 1;
            }
        }
        if (palindrome != 0) {
            System.out.println("Is it a palindrome? : True");
        } else {
            System.out.println("Is it a palindrome?: False");
        }

        System.out.println("-----------------------UC3-------------------");

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        if (reversed.equals(input)) {
            palindrome = 1;
        }

        if (palindrome != 0) {
            System.out.println("Is it a palindrome? : True");
        } else {
            System.out.println("Is it a palindrome?: False");
        }

        System.out.println("------------------------------UC4---------------------------");

        String input1 = "radar";
        char[] chars = input1.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input String: " + input1);
        if (isPalindrome) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }

        System.out.println("----------------------------UC5-------------------------------");

        String input2 = "noon";
        Stack<Character> stackUC5 = new Stack<>();
        for (char c : input2.toCharArray()) {
            stackUC5.push(c);
        }
        isPalindrome = true;
        for (char c : input2.toCharArray()) {
            if (c != stackUC5.pop()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Input String: " + input2);
        if (isPalindrome) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }

        System.out.println("----------------------------UC6-------------------------------");
        /**
         * Use Case 6: Queue + Stack Based Palindrome Check
         * Goal: Demonstrate FIFO vs LIFO using Queue and Stack.
         */

        // Define the input string to validate
        String inputUC6 = "civic";

        // Create a Queue (FIFO) and a Stack (LIFO)
        //
        Queue<Character> queueUC6 = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        // Enqueue and Push characters
        for (char c : inputUC6.toCharArray()) {
            queueUC6.add(c);     // FIFO order: [c, i, v, i, c]
            stackUC6.push(c);    // LIFO order: [c, i, v, i, c]
        }

        boolean isPalindromeUC6 = true;

        // Compare dequeue (FIFO - front) vs pop (LIFO - back)
        while (!queueUC6.isEmpty()) {
            if (!queueUC6.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println("Input: " + inputUC6);
        System.out.println("Is Palindrome?: " + isPalindromeUC6);

       System.out.println("----------------------------UC7-------------------------------");
        /**
         * Use Case 7: Deque-Based Optimized Palindrome Checker
         * Goal: Use Deque to compare front and rear elements.
         * Description:
         * This logic uses a Double-Ended Queue (Deque) to allow insertion 
         * and deletion from both ends. By removing the first and last 
         * characters simultaneously, we optimize the comparison process.
         */

        String inputUC7 = "deified";
        
        // Deque (Double Ended Queue) allows access to both front and rear
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        // Flow: Insert characters into deque
        for (char c : inputUC7.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeUC7 = true;

        // Flow: Remove first & last and Compare until empty or one element remains
        while (deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();

            if (!first.equals(last)) {
                isPalindromeUC7 = false;
                break;
            }
        }

        // Output results
        System.out.println("Input String: " + inputUC7);
        if (isPalindromeUC7) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}