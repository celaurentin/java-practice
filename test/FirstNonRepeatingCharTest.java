import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingCharTest {

    FirstNonRepeatingChar f = new FirstNonRepeatingChar();

    @Test
    void findFirstNonRepeating() {
        char expected1 = ' ';
        String word1  = "zxyzyx";
        char expected2 = 'a';
        String word2  = "zxyzyxabcdef";
        assertEquals(expected1, f.findFirstNonRepeating(word1));
        assertEquals(expected2, f.findFirstNonRepeating(word2));
    }
}
