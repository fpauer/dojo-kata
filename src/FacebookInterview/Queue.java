package FacebookInterview;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by fernandopauer on 4/28/17.
 *
 * Queue implementation
 */
public class Queue<T> {

    private class Node<T> {
        protected T value;
        protected Node next;
    }

    int size = 0;
    Node<T> head = null;

    public Queue() {
        head = new Node<>();
    }

    public void enqueue(T item) {
        Node<T> node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.value = item;
        node.next = new Node<>();
        size = size + 1;
    }

    public T peak() {
        if (head.value == null) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            return head.value;
        }
    }


    public T dequeue() {
        T value = peak();
        head = head.next;
        size = size - 1;
        return value;
    }

    public int size() {
        return size;
    }
}
