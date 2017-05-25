package FacebookInterview.DataStructures;

import sun.plugin.dom.exception.InvalidStateException;

/**
 * Created by fernandopauer on 5/4/17.
 * <p>
 * 22 minutes solved, but wrongly at the first time
 */
public class LinkedList<T> { 

    private class Node<T> { 
        public Node(T value) {
            this.value = value;
        }

        T value; 
        Node<T> next; 
    } 
    Node<T> head = null; 

    public void addFirst(T item) {
        Node<T> node = head;
        head = new Node<>(item);
        if (head != null) {
            head.next = node;
        }
    }

    public void addLast(T item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);;
        }
    }
 
    public Node<T> remove(T v) {
        if (head == null) throw new InvalidStateException("Linked list is empty");

        Node<T> node = head;
        Node<T> previous = head;

        while (node != null) {
            if (node.value.equals(v)) {
                previous.next = node.next;
                return node;
            } else {
                previous = node;
                node = node.next;
             }
        }

        return null;
    }
}