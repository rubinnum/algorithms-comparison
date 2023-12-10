import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class UnitTests {

    public static final InsertionSort insertionSort = new InsertionSort();
    public static final QuickSort quickSort = new QuickSort();
    public static final RadixSort radixSort = new RadixSort();
    public static final HeapSort heapSort = new HeapSort();

    @Test
    public void executeAlgorithmsTests() {

        int[] randomData = new int[]{3, 13, 7, 8, 2, 8, 9, 1, 5};
        int[] sortedData = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversedData = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        log.info("Executing tests on Insertion Sort");
        runTestOn(insertionSort, Arrays.copyOf(randomData, randomData.length));
        runTestOn(insertionSort, Arrays.copyOf(sortedData, sortedData.length));
        runTestOn(insertionSort, Arrays.copyOf(reversedData, reversedData.length));
        log.info("Insertion Sort passed all tests");

        log.info("Executing tests on Quick Sort");
        runTestOn(quickSort, Arrays.copyOf(randomData, randomData.length));
        runTestOn(quickSort, Arrays.copyOf(sortedData, sortedData.length));
        runTestOn(quickSort, Arrays.copyOf(reversedData, reversedData.length));
        log.info("Insertion Sort passed all tests");

        log.info("Executing tests on Radix Sort");
        runTestOn(radixSort, Arrays.copyOf(randomData, randomData.length));
        runTestOn(radixSort, Arrays.copyOf(sortedData, sortedData.length));
        runTestOn(radixSort, Arrays.copyOf(reversedData, reversedData.length));
        log.info("Radix Sort passed all tests");

        log.info("Executing tests on Heap Sort");
        runTestOn(heapSort, Arrays.copyOf(randomData, randomData.length));
        runTestOn(heapSort, Arrays.copyOf(sortedData, sortedData.length));
        runTestOn(heapSort, Arrays.copyOf(reversedData, reversedData.length));
        log.info("Heap Sort passed all tests");

    }

    private void runTestOn(Algorithm algorithm, int[] data) {
            algorithm.sort(data);
            boolean isSorted = isSorted(data);
            assertTrue(isSorted, "The array is not sorted, its current state: " + Arrays.toString(data));
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

}
