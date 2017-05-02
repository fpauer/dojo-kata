package FacebookInterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fernandopauer on 4/27/17.
 *
 * Do an in-place (without allocating any extra memory)
 * rearrangement of a list of integers, putting non-zero elements first.
 */
public class inPlaceIntegerList {

    private static void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static int[] rearrangement(int[] list) {
        int i = 0;
        int r = list.length-1;
        while (i < list.length && i<r) {
            if (list[i]==0) {
                if (list[r]!=0) {
                    swap(list, i, r);
                }
                r = r -1;
            } else {
                i = i+1;
            }
        }

        return list;
    }
}
