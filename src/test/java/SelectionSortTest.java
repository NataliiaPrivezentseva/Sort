public class SelectionSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new SelectionSort();
    }
}