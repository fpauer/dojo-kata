package FacebookInterview.DataStructures;

/**
 * Created by fernandopauer on 5/4/17.
 * 30 min !!!!!! BAD with bugs , null pointer in next and previous
 */
public class DoubledLinkedList<T> {

     private class Node<T> {

        public Node(T value) {
            this.value = value;
        }

        T value;
        Node<T> next;
        Node<T> previous;
    }

    Node<T> empty = new Node<>(null);
    Node<T> head = empty;
    Node<T> tail = empty;

    public void addFirst(T item) {
        Node<T> node = head;
        head = new Node<>(item);
        head.next = node;
        if (node.next == null) {
            tail = head;
        } else {
            node.previous = head;
        }
    }

    public void addLast(T item) {
        if (head.equals(empty)) {
            addFirst(item);
        } else {
            Node<T> node = tail;
            tail = new Node<>(item);
            tail.previous = node;
            node.next = tail;
        }
    }

    public Node<T> remove(T item) {
        Node<T> node = tail;
        if (node.equals(head) && node.value.equals(item)) {
            head = null;
            tail = null;
            return node;
        } else {
            Node<T> next = node;
            while (node!=null) {
                if (node.value.equals(item)) {
                    next.previous = node.previous;
                    if (node.previous != null) {
                        node.previous.next = next;
                    }
                    return node;

                } else {
                    next = node;
                    node = node.previous;
                }
            }
        }
    }
}
