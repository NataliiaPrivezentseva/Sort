public class QuickSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new QuickSort();
    }
}