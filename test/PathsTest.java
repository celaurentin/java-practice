import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathsTest {

    Paths pathService = new Paths();
    List<String> input = new ArrayList<>();

    @BeforeEach
    void setUp() {
        input.add("/a/folder1/folder12/file.txt");
        input.add("/a/folder1/folder13/file.txt");
        input.add("/a/folder2/folder12/file.txt");
        input.add("/a/folder3/folder12/file.txt");
        input.add("/a/folder1/folder12/file23.txt");
        input.add("/b/folder1/folder13/file.txt");
        input.add("/b/folder2/folder12/file.txt");
        input.add("/c/folder2/folder12/file.txt");
    }

    @Test
    void mostRecurringPath() {
        assertEquals("/a/folder1/folder12", pathService.mostRecurringPath(input));
    }
}
