import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackFromQueueTest {
    StackFromQueue stack;

    @BeforeEach
    void setUp() {
        stack = new StackFromQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    void pop() {
        assertEquals(3,stack.pop());
        assertEquals(2,stack.pop());
        assertEquals(1,stack.pop());
        assertEquals(-1, stack.pop());
    }

    @Test
    void peek() {
        assertEquals(3,stack.peek());
        assertEquals(3,stack.peek());
    }

    @Test
    void push() {
        stack.push(4);
        stack.push(5);
        assertEquals(5,stack.pop());
        assertEquals(4, stack.pop());
    }
}
