public class BubbleSortTest extends SortTest{

    @Override
    public SortNumbers getCollectionForSort() {
        return new BubbleSort();
    }
}