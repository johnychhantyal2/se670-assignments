import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedQueueTest {

    @Test
    public void testEnQueue() {
        BoundedQueue queue = new BoundedQueue(3);
        queue.enQueue(1);
        assertEquals(queue.toString(), "[1]");
    }

    @Test
    public void testDeQueue() {
        BoundedQueue queue = new BoundedQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        assertEquals(queue.toString(), "[2]");
    }

    @Test
    public void testIsEmpty() {
        BoundedQueue queue = new BoundedQueue(3);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        BoundedQueue queue = new BoundedQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        assertTrue(queue.isFull());
    }

    @Test
    public void testToString() {
        BoundedQueue queue = new BoundedQueue(4);

        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        assertEquals("[A, B, C]", queue.toString());
    }
}