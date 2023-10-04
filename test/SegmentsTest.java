import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentsTest {

    Segments seg = new Segments();

    @Test
    void countSegments() {
        String s1 = "Hello, my name is    John";
        String s2 = "Hello ";
        String s3 = "";
        assertEquals(5, seg.countSegments(s1));
        assertEquals(1, seg.countSegments(s2));
        assertEquals(0, seg.countSegments(s3));
    }
}
