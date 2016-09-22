public class HeapSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new HeapSort();
    }
}
