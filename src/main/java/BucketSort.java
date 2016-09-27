import java.util.ArrayList;
import java.util.List;

class BucketSort implements SortNumbers {

    private static List<List<Integer>> createBuckets(int minNumber, int maxNumber) {
        int amountOfBuckets = getAmountOfBuckets(minNumber, maxNumber);

        List<List<Integer>> bucket = new ArrayList<>();
        for (int j = 0; j < amountOfBuckets; j++) {
            bucket.add(j, new ArrayList<>());
        }

        return bucket;
    }

    private static List<List<Integer>> putIntoBuckets(List<Integer> numberCollection, List<List<Integer>> bucket,
                                                      int maxNumber, int minNumber) {
        int amountOfBuckets = bucket.size();
        int amountOfElementsInBucket = (maxNumber - minNumber / amountOfBuckets) + 1;
        int boarderNumber = maxNumber - amountOfElementsInBucket;
        for (Integer element : numberCollection) {
            while (amountOfBuckets > 0) {
                if (element > boarderNumber) {
                    ((ArrayList) bucket.get(amountOfBuckets - 1)).add(element);
                    break;
                } else {
                    amountOfBuckets--;
                    boarderNumber = boarderNumber - amountOfElementsInBucket;
                }
            }
            amountOfBuckets = bucket.size();
            boarderNumber = maxNumber - amountOfElementsInBucket;

        }

        return bucket;
    }

    private static int getAmountOfBuckets(int minNumber, int maxNumber) {
        int amountOfBuckets;
        if (maxNumber - minNumber <= 10) {
            amountOfBuckets = ((maxNumber - minNumber) / 5) + 1;
        } else if (maxNumber - minNumber > 10 && maxNumber - minNumber <= 100) {
            amountOfBuckets = ((maxNumber - minNumber) / 10) + 1;
        } else if (maxNumber - minNumber > 100 && maxNumber - minNumber <= 1000) {
            amountOfBuckets = ((maxNumber - minNumber) / 100) + 1;
        } else {
            amountOfBuckets = ((maxNumber - minNumber) / 1000) + 1;
        }
        return amountOfBuckets;
    }

    @Override
    public List<Integer> sortNumberCollection(List<Integer> numberCollection) {
        if (numberCollection.size() == 1) {
            return numberCollection;
        }

        int minNumber = numberCollection.get(0);
        int maxNumber = numberCollection.get(0);

        for (int i = 1; i < numberCollection.size(); i++) {
            if (minNumber > numberCollection.get(i)) {
                minNumber = numberCollection.get(i);
            } else if (maxNumber < numberCollection.get(i)) {
                maxNumber = numberCollection.get(i);
            }
        }

        List<List<Integer>> bucket = putIntoBuckets(numberCollection, createBuckets(minNumber, maxNumber),
                maxNumber, minNumber);
        numberCollection.clear();
        for (List part : bucket) {
            InsertionSort sort = new InsertionSort();
            sort.sortNumberCollection(part);
            numberCollection.addAll(part);
        }
        return numberCollection;
    }

}
