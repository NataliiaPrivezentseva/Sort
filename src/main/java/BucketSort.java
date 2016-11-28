import java.util.ArrayList;
import java.util.List;

class BucketSort implements SortNumbers {

    private static List<List<Integer>> createBuckets(NumberCollectionParameters parameters) {
        int amountOfBuckets = getAmountOfBuckets(parameters);

        List<List<Integer>> bucket = new ArrayList<>();
        for (int j = 0; j < amountOfBuckets; j++) {
            bucket.add(j, new ArrayList<>());
        }

        return bucket;
    }

    private static void putIntoBuckets(List<Integer> numberCollection,
                                       List<List<Integer>> bucket,
                                       NumberCollectionParameters parameters) {
        int amountOfBuckets = bucket.size();
        int amountOfElementsInBucket = ((parameters.getMaxNumber() - parameters.getMinNumber()) / amountOfBuckets) + 1;
        int boarderNumber = parameters.getMaxNumber() - amountOfElementsInBucket;
        for (Integer element : numberCollection) {
            while (amountOfBuckets > 0) {
                if (element > boarderNumber) {
                    (bucket.get(amountOfBuckets - 1)).add(element);
                    break;
                } else {
                    amountOfBuckets--;
                    boarderNumber = boarderNumber - amountOfElementsInBucket;
                }
            }
            amountOfBuckets = bucket.size();
            boarderNumber = parameters.getMaxNumber() - amountOfElementsInBucket;

        }
    }

    private static int getAmountOfBuckets(NumberCollectionParameters parameters) {
        int amountOfBuckets;
        if (parameters.getMaxNumber() - parameters.getMinNumber() <= 10) {
            amountOfBuckets = ((parameters.getMaxNumber() - parameters.getMinNumber()) / 5) + 1;
        } else if (parameters.getMaxNumber() - parameters.getMinNumber() > 10 && parameters.getMaxNumber() - parameters.getMinNumber() <= 100) {
            amountOfBuckets = ((parameters.getMaxNumber() - parameters.getMinNumber()) / 10) + 1;
        } else if (parameters.getMaxNumber() - parameters.getMinNumber() > 100 && parameters.getMaxNumber() - parameters.getMinNumber() <= 1000) {
            amountOfBuckets = ((parameters.getMaxNumber() - parameters.getMinNumber()) / 100) + 1;
        } else {
            amountOfBuckets = ((parameters.getMaxNumber() - parameters.getMinNumber()) / 1000) + 1;
        }
        return amountOfBuckets;
    }

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        if (numberCollection.size() == 1) {
            return;
        }

        BucketSort bucketSort = new BucketSort();
        BucketSort.NumberCollectionParameters parameters = bucketSort.new NumberCollectionParameters(numberCollection);

        List<List<Integer>> bucket = createBuckets(parameters);
        putIntoBuckets(numberCollection, bucket, parameters);

        List<Integer> sortedNumberCollection = new ArrayList<>();
        for (List<Integer> part : bucket) {
            InsertionSort sort = new InsertionSort();
            sort.sortNumberCollection(part);
            sortedNumberCollection.addAll(part);
        }

        for (int i = 0; i < sortedNumberCollection.size(); i++) {
            numberCollection.set(i, sortedNumberCollection.get(i));
        }
    }

    private class NumberCollectionParameters {
        private int minNumber;
        private int maxNumber;

        NumberCollectionParameters (List<Integer> numberCollection){
            minNumber = numberCollection.get(0);
            maxNumber = numberCollection.get(0);
            for (int i = 1; i < numberCollection.size(); i++) {
                if (minNumber > numberCollection.get(i)) {
                    minNumber = numberCollection.get(i);
                } else if (maxNumber < numberCollection.get(i)) {
                    maxNumber = numberCollection.get(i);
                }
            }
        }

        int getMinNumber() {
            return minNumber;
        }

        int getMaxNumber() {
            return maxNumber;
        }
    }
}
