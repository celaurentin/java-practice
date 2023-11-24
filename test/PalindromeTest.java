import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    Palindrome p = new Palindrome();

    @Test
    void isPalindrome() {
        assertTrue(p.isPalindrome(121));
        assertTrue(p.isPalindrome(99));
        assertFalse(p.isPalindrome(-121));
        assertFalse(p.isPalindrome(10));
    }
}
