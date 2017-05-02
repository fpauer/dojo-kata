package FacebookInterview;

/**
 * Created by fernandopauer on 4/27/17.
 *
 * Binary search implementation
 */
public class BinarySearch {

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node search(Node head, int value) {
        if (head == null) return null;

        if (value < head.value) {
            return search(head.left, value);
        }
        if (value > head.value) {
            return search(head.right, value);
        }

        return head;
    }
}
