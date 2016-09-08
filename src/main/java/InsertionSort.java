import java.util.Collections;
import java.util.List;

class InsertionSort implements SortNumbers {

    @Override
    public List<Integer> sortNumberCollection(List<Integer> numberCollection) {
        for (int i = 1; i < numberCollection.size(); i++) {
            int movedElement = numberCollection.get(i);
            int j, start;

            for (j = i - 1; j >= 0 && movedElement < numberCollection.get(j); j--);
            start = j + 1;
            Collections.rotate(numberCollection.subList(start, i + 1), -(i - start));
        }
        return numberCollection;
    }
}