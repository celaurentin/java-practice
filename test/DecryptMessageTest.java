import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptMessageTest {

    DecryptMessage decryptMessage = new DecryptMessage();

    @Test
    void decrypt() {
        String word1 = "dnotq";
        String expected1 = "crime";

        String word2 = "flgxswdliefy";
        String expected2 = "encyclopedia";

        assertEquals(expected1, decryptMessage.decrypt(word1));
        assertEquals(expected2, decryptMessage.decrypt(word2));
    }
}
