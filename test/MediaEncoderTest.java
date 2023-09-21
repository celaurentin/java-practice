import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MediaEncoderTest {
    MediaEncoder encoder = new MediaEncoder();

    @Test
    void minimumTime() {
        List<Integer> files = new ArrayList<>();
        files.add(8); files.add(4); files.add(6); files.add(12);
        assertEquals(58, encoder.minimumTime(4, files));
    }
}
