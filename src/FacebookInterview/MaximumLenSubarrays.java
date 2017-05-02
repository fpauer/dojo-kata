package FacebookInterview;

/**
 * Created by fernandopauer on 4/28/17.
 *
 * Find maximum length of continous subarrays within an array
 *
 */
public class MaximumLenSubarrays {

    public int maxLength(Object[] array) {
        if (array==null) return 0;
        return count(0, array);
    }

    public int count(int seed, Object[] array) {
        int count = seed;
        for(Object arr: array) {
            if (arr != null && arr.getClass().isArray()) {
                int temp = count(seed+1, (Object[])arr);
                if (temp >= count) {
                    count = temp;
                }
            }
        }
        if (count >= seed) {
            seed = count;
        }
        return seed;
    }
}
