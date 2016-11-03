import java.util.Collections;
import java.util.List;

class BubbleSort implements SortNumbers {

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        for (int i = numberCollection.size() - 1; i > 0; i--) {
          boolean swapped = false;

            for (int j = 0; j < i; j++) {
                if(numberCollection.get(j) > numberCollection.get(j + 1)) {
                   Collections.swap(numberCollection, j, j+1);
                   swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }
}