import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

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
        String inputUC6 = "civic";
        Queue<Character> queueUC6 = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char c : inputUC6.toCharArray()) {
            queueUC6.add(c);
            stackUC6.push(c);
        }

        boolean isPalindromeUC6 = true;
        while (!queueUC6.isEmpty()) {
            if (!queueUC6.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }
        System.out.println("Input: " + inputUC6);
        System.out.println("Is Palindrome?: " + isPalindromeUC6);

        System.out.println("----------------------------UC7-------------------------------");
        String inputUC7 = "deified";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : inputUC7.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            if (!first.equals(last)) {
                isPalindromeUC7 = false;
                break;
            }
        }
        System.out.println("Input String: " + inputUC7);
        System.out.println("Result: " + (isPalindromeUC7 ? "The string is a palindrome." : "The string is NOT a palindrome."));

        System.out.println("----------------------------UC8-------------------------------");
        String inputUC8 = "racecar";
        Node head = null;
        Node tail = null;
        for (char c : inputUC8.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindromeUC8 = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("Input String: " + inputUC8);
        System.out.println("Result: " + (isPalindromeUC8 ? "Palindrome" : "NOT a Palindrome"));

        System.out.println("----------------------------UC9-------------------------------");
        String inputUC9 = "level";
        boolean isPalindromeUC9 = isPalindromeRecursive(inputUC9, 0, inputUC9.length() - 1);

        System.out.println("Input String: " + inputUC9);
        System.out.println("Result: " + (isPalindromeUC9 ? "The string is a palindrome." : "The string is NOT a palindrome."));
        
    } // End of main method

    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
} // End of Main class

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}