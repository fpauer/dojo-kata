package FacebookInterview;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernandopauer on 4/28/17.
 */
class QueueTest {

    Queue<Integer> queue = new Queue<>();

    @Test
    void enqueue() {
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.size(), 4);
    }

    @Test
    void dequeue() {
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.dequeue(), new Integer(0));
        assertEquals(queue.dequeue(), new Integer(1));
        assertEquals(queue.dequeue(), new Integer(2));
        assertEquals(queue.dequeue(), new Integer(3));
    }

    @Test
    void dequeueEmpty() {
        Throwable exception = assertThrows(NoSuchElementException.class, () -> {
            System.out.println(queue.dequeue());
        });
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void peak() {
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.peak(), new Integer(0));
    }

    @Test
    void peakEmpty() {
        Throwable exception = assertThrows(NoSuchElementException.class, () -> {
            queue.peak();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }
}