import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class SortTest {

    private static List<Pair<List<Integer>, List<Integer>>> collection;

    @BeforeClass
    public static void init() {
        List<Integer> numberCollectionFirst = Arrays.asList(8, 5, 12, 0, 36, 56, 125, 2, 584, 0, 12, 54);
        List<Integer> sortedNumberCollectionFirst = Arrays.asList(0, 0, 2, 5, 8, 12, 12, 36, 54, 56, 125, 584);
        List<Integer> numberCollectionSecond = Arrays.asList(3658, 218, 123, 215, 57, 15, 0, 4, 65);
        List<Integer> sortedNumberCollectionSecond = Arrays.asList(0, 4, 15, 57, 65, 123, 215, 218, 3658);
        List<Integer> numberCollectionThird = Arrays.asList(10, 9, 8, 7, 6, 5, -4, 3, 2, 1, 2, 0);
        List<Integer> sortedNumberCollectionThird = Arrays.asList(-4, 0, 1, 2, 2, 3, 5, 6, 7, 8, 9, 10);
        List<Integer> numberCollectionForth = Arrays.asList(22, 16, 38, 56, 729, 123456);
        List<Integer> sortedNumberCollectionForth = Arrays.asList(16, 22, 38, 56, 729, 123456);
        collection = new ArrayList<>();
        collection.add(Pair.of(numberCollectionFirst, sortedNumberCollectionFirst));
        collection.add(Pair.of(numberCollectionSecond, sortedNumberCollectionSecond));
        collection.add(Pair.of(numberCollectionThird, sortedNumberCollectionThird));
        collection.add(Pair.of(numberCollectionForth, sortedNumberCollectionForth));
    }

    public abstract SortNumbers getCollectionForSort();

    @Test
    public void sortNumberCollectionTest() {

        for (Pair<List<Integer>, List<Integer>> i : collection) {
            getCollectionForSort().sortNumberCollection(i.getLeft());
            List<Integer> expected = i.getLeft();
            List<Integer> actual = i.getRight();
            Assert.assertEquals(expected, actual);
        }
    }
}
