import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTests {

    InsertionSort insertionSort = new InsertionSort();
    QuickSort quickSort = new QuickSort();

    @Test
    public void executeAlgorithmsTests() {
        runTestOn(insertionSort);
        runTestOn(quickSort);
    }

    private void runTestOn(Algorithm algorithm) {
            int[] data = {3, 13, 7, 8, 2, 8, 9, 1, 5};
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
