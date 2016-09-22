public class ShellSortTest extends SortTest {

    @Override
    public SortNumbers getCollectionForSort() {
        return new ShellSort();
    }
}