import java.util.Collections;
import java.util.List;

class InsertionSort implements SortNumbers {

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        for (int i = 1; i < numberCollection.size(); i++) {
            int movedElement = numberCollection.get(i);
            int start = i - 1;

            while (start >= 0 && movedElement < numberCollection.get(start)) {
                start--;
            }
            start++;

            Collections.rotate(numberCollection.subList(start, i + 1), -(i - start));
        }
    }

}