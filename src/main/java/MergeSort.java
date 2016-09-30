import java.util.ArrayList;
import java.util.List;

class MergeSort implements SortNumbers {

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        if (numberCollection.size() <= 1) {
            return;
        }

        // divide NumberCollection

        int boarder = numberCollection.size() / 2;
        List<Integer> firstPart = new ArrayList<>(numberCollection.subList(0, boarder));
        List<Integer> secondPart = new ArrayList<>(numberCollection.subList(boarder, numberCollection.size()));

        // sort each part

        sortNumberCollection(firstPart);
        sortNumberCollection(secondPart);

        // combine to NumberCollection
        int indexFirstPart = 0;
        int indexSecondPart = 0;
        int indexNumberCollection = 0;
        while (indexFirstPart < firstPart.size() && indexSecondPart < secondPart.size()) {
            if (firstPart.get(indexFirstPart) < secondPart.get(indexSecondPart)) {
                numberCollection.set(indexNumberCollection, firstPart.get(indexFirstPart));
                indexFirstPart++;
            } else {
                numberCollection.set(indexNumberCollection, secondPart.get(indexSecondPart));
                indexSecondPart++;
            }
            indexNumberCollection++;
        }

        // add the rest of elements to NumberCollection
        if (indexFirstPart < indexSecondPart) {
            while (indexFirstPart < firstPart.size()) {
                numberCollection.set(indexNumberCollection, firstPart.get(indexFirstPart));
                indexFirstPart++;
                indexNumberCollection++;
            }
        }
        else {
            while (indexSecondPart < secondPart.size()) {
                numberCollection.set(indexNumberCollection, secondPart.get(indexSecondPart));
                indexSecondPart++;
                indexNumberCollection++;
            }
        }
    }

}
