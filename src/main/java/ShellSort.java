import java.util.List;

class ShellSort implements SortNumbers {

    @Override
    public List<Integer> sortNumberCollection(List<Integer> numberCollection) {
        int step = numberCollection.size() / 2;

        while (step >= 1) {

            for (int i = step; i < numberCollection.size(); i++) {
                int movedElement = numberCollection.get(i);
                int j;

                for (j = i - step; j >= 0 && movedElement < numberCollection.get(j); j = j - step) {
                    numberCollection.set(j + step, numberCollection.get(j));
                }
                numberCollection.set(j + step, movedElement);
            }

            step = step / 2;
        }
        return numberCollection;
    }
}