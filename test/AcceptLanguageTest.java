import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcceptLanguageTest {

    AcceptLanguage acceptLanguage = new AcceptLanguage();

    String acceptHeader;
    String[] supportedLanguage;
    List<String> expectedResult;

    @Test
    void solutionTestCase1() {
        // #1
        acceptHeader = "en-US, fr-CA, fr-FR";
        supportedLanguage = new String[]{"fr-FR", "en-US"};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");
        expectedResult.add("fr-FR");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase2() {
        // #2
        acceptHeader = "fr-CA, fr-FR";
        supportedLanguage = new String[]{"en-US", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("fr-FR");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase3() {
        // #3
        acceptHeader = "en-US";
        supportedLanguage = new String[]{"en-US", "fr-CA"};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase4() {
        // #4
        acceptHeader = "en";
        supportedLanguage = new String[]{"en-US", "fr-CA", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase5() {
        // #5
        acceptHeader = "fr";
        supportedLanguage = new String[]{"en-US", "fr-CA", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("fr-CA");
        expectedResult.add("fr-FR");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase6() {
        // #6
        acceptHeader = "fr-FR, fr";
        supportedLanguage = new String[]{"en-US", "fr-CA", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("fr-FR");
        expectedResult.add("fr-CA");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase7() {
        // #7
        acceptHeader = "en-US, *";
        supportedLanguage = new String[]{"en-US", "fr-CA", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");
        expectedResult.add("fr-CA");
        expectedResult.add("fr-FR");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase8() {
        // #8
        acceptHeader = "fr-FR, fr, *";
        supportedLanguage = new String[]{"en-US", "fr-CA", "fr-FR"};
        expectedResult = new ArrayList<>();
        expectedResult.add("fr-FR");
        expectedResult.add("fr-CA");
        expectedResult.add("en-US");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase9() {
        // #8
        acceptHeader = "fr-FR, fr, *";
        supportedLanguage = new String[]{};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
    @Test
    void solutionTestCase10() {
        // #8
        acceptHeader = "*";
        supportedLanguage = new String[]{"en-US", "fr-CA"};
        expectedResult = new ArrayList<>();
        expectedResult.add("en-US");
        expectedResult.add("fr-CA");

        assertEquals(expectedResult, acceptLanguage.solution(acceptHeader, supportedLanguage));
    }
}
