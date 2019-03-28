package A03AutoComplete;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Adam Gardner on 10/16/16.
 */
public class BinarySearchDeluxe {

    //Guaranteed to always find the first index that has the key value stored in it.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0, hi = a.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) <= 0){
                hi = mid;
            } else
                lo = mid;
        }
        if (comparator.compare(key, a[lo]) == 0) return lo;
        if (comparator.compare(key, a[hi]) == 0) return hi;

        return -1;
    }

    //Guaranteed to always find the last index that has the key value stored in it.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0, hi = a.length - 1;
        Arrays.sort(a);
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) < 0){
                hi = mid;
            }else
                lo = mid;
        }
        if (comparator.compare(key, a[hi]) == 0) return hi;
        if (comparator.compare(key, a[lo]) == 0) return lo;

        return -1;
    }


}
