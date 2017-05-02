package FacebookInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernandopauer on 4/27/17.
 */
class inPlaceIntegerListTest {

    @Test
    void rearrangement() {
        int[] result = {1, 1, -1, 0, 0};

        int[] ints1 = {1, 0, -1, 1, 0};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints1));

        int[] ints2 = {0, 0, -1, 1, 1};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints2));

        int[] ints3 = {0, 1, -1, 0, 1};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints3));
    }

    @Test
    void rearrangement2() {
        int[] result = {1, 1, 0, 0, 0};

        int[] ints1 = {1, 0, 1, 0, 0};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints1));

        int[] ints2 = {0, 0, 0, 1, 1};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints2));

        int[] ints3 = {0, 0, 1, 0, 1};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(ints3));
    }

    @Test
    void edgeCaseZero() {
        int[] result = {0, 0, 0, 0, 0};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(result));
    }

    @Test
    void edgeCaseNonZero() {
        int[] result = {1, -1, 2, 3, -4};
        assertArrayEquals(result, inPlaceIntegerList.rearrangement(result));
    }
}