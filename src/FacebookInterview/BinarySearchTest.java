package FacebookInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernandopauer on 4/27/17.
 */
class BinarySearchTest {


    @Test
    void search() {
        BinarySearch binarySearch = new BinarySearch();
        BinarySearch.Node head = binarySearch. new Node(4);
        BinarySearch.Node left1 = binarySearch. new Node(2);
        BinarySearch.Node right1 = binarySearch. new Node(6);
        head.left = left1;
        head.right = right1;

        BinarySearch.Node left1_1 = binarySearch. new Node(1);
        BinarySearch.Node right1_2 = binarySearch. new Node(3);
        left1.left = left1_1;
        left1.right = right1_2;

        BinarySearch.Node left2_1 = binarySearch. new Node(5);
        BinarySearch.Node right2_2 = binarySearch. new Node(7);
        right1.left = left2_1;
        right1.right = right2_2;

        assertEquals(head, binarySearch.search(head, head.value));
        assertEquals(left1, binarySearch.search(head, left1.value));
        assertEquals(right1, binarySearch.search(head, right1.value));
        assertEquals(left1_1, binarySearch.search(head, left1_1.value));
        assertEquals(right1_2, binarySearch.search(head, right1_2.value));
        assertEquals(left2_1, binarySearch.search(head, left2_1.value));
        assertEquals(right2_2, binarySearch.search(head, right2_2.value));
    }

}