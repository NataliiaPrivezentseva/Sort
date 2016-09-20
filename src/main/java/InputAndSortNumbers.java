import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputAndSortNumbers {

    public static void main(String[] args) {
        System.out.println("Please, input your numbers to sort");

        Scanner scanner = new Scanner(System.in);
        List<Integer> numberCollection = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numberCollection.add(scanner.nextInt());
        }

        printNumberCollection(numberCollection);

        SortNumbers chosenSortMethod = chooseSortMethod();
        chosenSortMethod.sortNumberCollection(numberCollection);
        printNumberCollection(numberCollection);
    }

    private static void printNumberCollection(List<Integer> numberCollection){
        for (Integer i : numberCollection)
            System.out.print(i + "\t");
        System.out.println();
    }

    private static SortNumbers chooseSortMethod(){
        System.out.println("Please, choose sortNumberCollection method:\n" +
                "1 — Bubble Sort\n" +
                "2 — Selection Sort\n" +
                "3 — Insertion Sort\n" +
                "4 — Shell Sort\n" +
                "5 — Quick Sort\n" +
                "6 — Bucket Sort\n" +
                "7 — Merge Sort\n" +
                "8 — Heap Sort");

        Scanner input = new Scanner(System.in);
        int choice;
        choice = input.nextInt();

        SortNumbers chosenSortMethod = null;

        switch (choice){
            case 1: chosenSortMethod = new BubbleSort();
                break;
            case 2: chosenSortMethod = new SelectionSort();
                break;
            case 3: chosenSortMethod = new InsertionSort();
                break;
            case 4: chosenSortMethod = new ShellSort();
                break;
            case 5: chosenSortMethod = new QuickSort();
                break;
            case 6: chosenSortMethod = new BucketSort();
                break;
            case 7: chosenSortMethod = new MergeSort();
                break;
            case 8: chosenSortMethod = new HeapSort();
                break;
            default:
                System.out.println("Please, choose proper option!");
                System.exit(-1);
        }
        return chosenSortMethod;
    }
}

