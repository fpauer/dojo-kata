package FacebookInterview;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernandopauer on 4/28/17.
 */
class MaximumLenSubarraysTest {

    MaximumLenSubarrays lenSubarrays;
    @BeforeEach
    void setUp() {
        lenSubarrays = new MaximumLenSubarrays();
    }

    @Test
    void maxLengthSimpleCases() {
        assertEquals(0, lenSubarrays.maxLength(new Object[1]));

        Object[] len1 = { new Integer[1] };
        assertEquals(1, lenSubarrays.maxLength(len1));

        Object[] len2 = { len1 };
        assertEquals(2, lenSubarrays.maxLength(len2));
    }

    @Test
    void maxLengthCommonCases() {
        assertEquals(0, lenSubarrays.maxLength(new Object[1]));

        Object[] len1 = { new Integer[1] };
        Object[] len2 = { len1 };
        Object[] len3 = { new Integer[1], len2};
        Object[] len4 = { len1, len2, len3 };
        assertEquals(4, lenSubarrays.maxLength(len4));
    }

    @Test
    void maxLengthEdgeCases() {
        assertEquals(0, lenSubarrays.maxLength(null));

        Object[] len1 = { new Integer[1] };
        Object[] len2 = { len1 };
        Object[] len3 = { new Integer[1], len2};
        Object[] len4 = { len1, len2, len3 };
        Object[] len5 = { len1, len4, len3, len2 };
        Object[] len6 = { len5, len4, len3, len2, len1 };
        Object[] len7 = { len1, len2, len6, len4, len5, len3 };
        Object[] len8 = { len1, len6, len3, len4, len5, len7, len2 };
        Object[] len9 = { len1, len2, len3, len4, len5, len8, len7, len6 };
        Object[] len10 = { len1, len2, len9, len4, len5, len6, len7, len8 };
        assertEquals(5, lenSubarrays.maxLength(len5));
        assertEquals(6, lenSubarrays.maxLength(len6));
        assertEquals(7, lenSubarrays.maxLength(len7));
        assertEquals(8, lenSubarrays.maxLength(len8));
        assertEquals(9, lenSubarrays.maxLength(len9));
        assertEquals(10, lenSubarrays.maxLength(len10));
    }
}