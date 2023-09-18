import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void scenario1() {
        Factorial fact = new Factorial();
        long[] numbers1 = {5,6,3};
        long[][] results1 = {{120,4},{720,1},{6,0}};

        assertArrayEquals(results1, fact.solution(numbers1));
        }

    @Test
    void scenario2() {
        Factorial fact = new Factorial();
        long[] numbers2 = {1,3,5};
        long[][] results2 = {{1,0},{6,2},{120,2}};

         assertArrayEquals(results2, fact.solution(numbers2));
    }
}
