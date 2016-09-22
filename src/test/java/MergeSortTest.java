public class MergeSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new MergeSort();
    }
}