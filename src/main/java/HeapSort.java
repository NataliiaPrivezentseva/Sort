import java.util.ArrayList;
import java.util.List;

class HeapSort implements SortNumbers {

    private ArrayList<Integer> heap = new ArrayList<>();

    private static void addToHeap(ArrayList<Integer> heap, Integer element) {
        if (heap.isEmpty()) {
            heap.add(null);
            heap.add(element);
        } else {
            heap.add(element);
            int index = heap.size() - 1;
            while (index > 1 && heap.get(index) > heap.get(index / 2)) {
                int tmp = heap.get(index);
                heap.set(index, heap.get(index / 2));
                heap.set(index / 2, tmp);
                index = index / 2;
            }
        }
    }

    private static int removeFromHeap(ArrayList<Integer> heap) {
        int element = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int top = 1;
        while (top * 2 <= heap.size() - 1) {
            int max = top * 2;
            if (max + 1 <= heap.size() - 1 && heap.get(max + 1) > heap.get(max)) {
                max = max + 1;
            }
            boolean swapped = false;
            if (heap.get(top) < heap.get(max)) {
                int tmp = heap.get(top);
                heap.set(top, heap.get(max));
                heap.set(max, tmp);
                top = max;
                swapped = true;
            }
            if (!swapped) {
                break;
            }
        }

        return element;
    }

    @Override
    public void sortNumberCollection(List<Integer> numberCollection) {
        // made heap from numberCollection
        for (Integer element : numberCollection) {
            addToHeap(heap, element);
        }

        for (int j = numberCollection.size() - 1; j >= 0; j--) {
            numberCollection.set(j, removeFromHeap(heap));
        }
    }

}


