public class BucketSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new BucketSort();
    }
}