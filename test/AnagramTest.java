import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void testAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
        assertTrue(Anagram.isAnagram("cat", "cat"));
        assertTrue(Anagram.isAnagram("act", "cat"));
        assertTrue(Anagram.isAnagram("aeiou", "uoiea"));
        assertTrue(Anagram.isAnagram("", ""));
        assertFalse(Anagram.isAnagram("cesar", "pete"));
        assertFalse(Anagram.isAnagram("cesar", "pet"));
    }
}
