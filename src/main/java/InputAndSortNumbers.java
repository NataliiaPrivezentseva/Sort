import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputAndSortNumbers {

    public static void main(String[] args) {
        List<Integer> numberCollection = getNumbersFromUser();

        printNumberCollection(numberCollection);
        chooseSortMethod().sortNumberCollection(numberCollection);
        printNumberCollection(numberCollection);
    }

    private static List<Integer> getNumbersFromUser() {
        System.out.println("Please, input your numbers to sort");

        Scanner scanner = new Scanner(System.in);
        List<Integer> numberCollection = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numberCollection.add(scanner.nextInt());
        }
        return numberCollection;
    }

    private static void printNumberCollection(List<Integer> numberCollection) {
        for (Integer i : numberCollection)
            System.out.print(i + "\t");
        System.out.println();
    }

    private static SortNumbers chooseSortMethod() {
        int choice = 0;
        String usersChoice;
        Scanner input = new Scanner(System.in);
        String regex = "[1-8]";
        do {
            System.out.println("Please, choose sortNumberCollection method:\n" +
                    "1 — Bubble Sort\n" +
                    "2 — Selection Sort\n" +
                    "3 — Insertion Sort\n" +
                    "4 — Shell Sort\n" +
                    "5 — Quick Sort\n" +
                    "6 — Bucket Sort\n" +
                    "7 — Merge Sort\n" +
                    "8 — Heap Sort");

            usersChoice = input.next();
            try {
                choice = Integer.parseInt(usersChoice);
            } catch (NumberFormatException e) {
                System.out.println("\'" + usersChoice + "\' is not proper choice! Try again!");
            }

            if (!usersChoice.matches(regex)) {
                System.out.println("\'" + usersChoice + "\' is not proper choice! Try again!");
            }

        } while (!usersChoice.matches(regex));

        SortNumbers chosenSortMethod;
        switch (choice) {
            case 1:
                chosenSortMethod = new BubbleSort();
                break;
            case 2:
                chosenSortMethod = new SelectionSort();
                break;
            case 3:
                chosenSortMethod = new InsertionSort();
                break;
            case 4:
                chosenSortMethod = new ShellSort();
                break;
            case 5:
                chosenSortMethod = new QuickSort();
                break;
            case 6:
                chosenSortMethod = new BucketSort();
                break;
            case 7:
                chosenSortMethod = new MergeSort();
                break;
            case 8:
                chosenSortMethod = new HeapSort();
                break;
            default:
                throw new InputMismatchException();
        }
        return chosenSortMethod;
    }

}

