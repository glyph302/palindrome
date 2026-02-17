 public class Main {

    public static void main(String[] args) {

        // Create objects
        PalindromeWelcome welcome = new PalindromeWelcome();
        PalindromeHardcode ph = new PalindromeHardcode();
        PalindromeReverse rv = new PalindromeReverse();

        // Call methods
        welcome.displayMessage();
        System.out.println("checking for madam: " + ph.hardcodePaliCheck("madam"));
        System.out.println("checking for hello " + ph.hardcodePaliCheck("hello"));
        System.out.println("Hello reversed is: " + rv.reverseString("hello"));
    }
}
