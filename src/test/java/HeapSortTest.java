import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HeapSortTest {

    private HeapSort collectionTest = new HeapSort();

    private List<Integer> numberCollectionFirst = Arrays.asList(8, 5, 12, 0, 36, 56, 125, 2, 584, 0, 12, 54);
    private List<Integer> sortedNumberCollectionFirst = Arrays.asList(0, 0, 2, 5, 8, 12, 12, 36, 54, 56, 125, 584);
    private List<Integer> numberCollectionSecond = Arrays.asList(3658, 218, 123, 215, 57, 15, 0, 4, 65);
    private List<Integer> sortedNumberCollectionSecond = Arrays.asList(0, 4, 15, 57, 65, 123, 215, 218, 3658);
    private List<Integer> numberCollectionThird = Arrays.asList(10, 9, 8, 7, 6, 5, -4, 3, 2, 1, 2, 0);
    private List<Integer> sortedNumberCollectionThird = Arrays.asList(-4, 0, 1, 2, 2, 3, 5, 6, 7, 8, 9, 10);

    @Test
    public void sortNumberCollection()  {
        Assert.assertEquals(collectionTest.sortNumberCollection(numberCollectionFirst), sortedNumberCollectionFirst);
        Assert.assertEquals(collectionTest.sortNumberCollection(numberCollectionSecond), sortedNumberCollectionSecond);
        Assert.assertEquals(collectionTest.sortNumberCollection(numberCollectionThird), sortedNumberCollectionThird);
    }

}