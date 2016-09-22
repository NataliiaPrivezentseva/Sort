public class InsertionSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new InsertionSort();
    }
}