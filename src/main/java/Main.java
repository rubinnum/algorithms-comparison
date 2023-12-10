import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static final InsertionSort insertionSort = new InsertionSort();
    public static final QuickSort quickSort  = new QuickSort();
    public static final RadixSort radixSort = new RadixSort();
    public static final HeapSort heapSort = new HeapSort();

    public static void main(String[] args) throws IOException {
        File csvFile = new File("utilities/data.csv");
        PrintWriter printWriter = new PrintWriter(csvFile);
        printWriter.println("InputSize InsertionSort QuickSort RadixSort HeapSort InsertionSortSorted QuickSortSorted RadixSortSorted HeapSortSorted");

        final int executionsNumber = 100;
        for (int power = 1; power < 10_000; power *= 10) {
            for (int multiplier = 1; multiplier < 10; multiplier++) {
                int size = multiplier * power;
                int[] array = new int[size];

                long insertionTime = 0, quickTime = 0, radixTime = 0, heapTime = 0;
                long insertionSortedTime = 0, quickSortedTime = 0, radixSortedTime = 0, heapSortedTime = 0;

                for (int time = 0; time < executionsNumber; time++) {
                    for (int i = 0; i < size; i++) {
                        array[i] = generateRandomInt(0, size);
                    }
                    insertionTime += getTimeOfExecuting(insertionSort, Arrays.copyOf(array, array.length));
                    quickTime += getTimeOfExecuting(quickSort, Arrays.copyOf(array, array.length));
                    radixTime += getTimeOfExecuting(radixSort, Arrays.copyOf(array, array.length));
                    heapTime += getTimeOfExecuting(heapSort, Arrays.copyOf(array, array.length));

                    for (int i = 0; i < size; i++) {
                        array[i] = i;
                    }
                    insertionSortedTime += getTimeOfExecuting(insertionSort, Arrays.copyOf(array, array.length));
                    quickSortedTime += getTimeOfExecuting(quickSort, Arrays.copyOf(array, array.length));
                    radixSortedTime += getTimeOfExecuting(radixSort, Arrays.copyOf(array, array.length));
                    heapSortedTime += getTimeOfExecuting(heapSort, Arrays.copyOf(array, array.length));
                }
                String newLine = String.format("%d %d %d %d %d %d %d %d %d", size, insertionTime / executionsNumber,
                        quickTime / executionsNumber, radixTime / executionsNumber, heapTime / executionsNumber,
                        insertionSortedTime / executionsNumber, quickSortedTime / executionsNumber,
                        radixSortedTime / executionsNumber, heapSortedTime / executionsNumber);
                printWriter.println(newLine);
            }
        }

        printWriter.close();
    }

    private static long getTimeOfExecuting(Algorithm algorithm, int[] array) {
        long startTime = System.nanoTime();
        algorithm.sort(array);
        long endTime = System.nanoTime();
        boolean isSorted = isSorted(array);
        assertTrue(isSorted, "The array is not sorted: " + Arrays.toString(array));
        return endTime - startTime;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}