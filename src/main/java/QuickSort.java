import java.util.Collections;
import java.util.List;

class QuickSort implements SortNumbers {

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        int collectionSize = numberCollection.size();
        int startIndex = 0;
        int finishIndex = collectionSize - 1;
        int baseElement = (numberCollection.get(startIndex) + numberCollection.get(finishIndex)) / 2;

        while (startIndex <= finishIndex) {
            while (numberCollection.get(startIndex) < baseElement) {
                startIndex++;
            }
            while (numberCollection.get(finishIndex) > baseElement) {
                finishIndex--;
            }
            if (startIndex <= finishIndex) {
                Collections.swap(numberCollection, startIndex, finishIndex);
                startIndex++;
                finishIndex--;
            }
        }

        if (finishIndex > 0) {
            sortNumberCollection(numberCollection.subList(0, finishIndex + 1));
        }

        if (startIndex < collectionSize) {
            sortNumberCollection(numberCollection.subList(startIndex, collectionSize));
        }
    }
}
