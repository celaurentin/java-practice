import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MediaEncoderTest {
    MediaEncoder encoder = new MediaEncoder();

    @Test
    void minimumTime() {
        int[] inputFiles = new int[]{8,4,6,12};
        assertEquals(58, encoder.minimumTime(inputFiles.length, inputFiles));
    }
}
