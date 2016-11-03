import java.util.Collections;
import java.util.List;

class SelectionSort implements SortNumbers {

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        for (int i = 0; i < numberCollection.size() - 1; i++) {
            int min = numberCollection.get(i);
            int indexMin = i;

            for (int j = i + 1; j < numberCollection.size(); j++) {
                if (min > numberCollection.get(j)) {
                    min = numberCollection.get(j);
                    indexMin = j;
                }
            }

            if (i != indexMin) {
                Collections.swap(numberCollection, i, indexMin);
            }
        }
    }
}
