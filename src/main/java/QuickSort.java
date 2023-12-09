public class QuickSort implements Algorithm {

    @Override
    public void sort(int[] array) {
        doSort(array, 0, array.length - 1);
    }

    private void doSort(int[] array, int startPos, int endPos) {
        if (startPos < endPos) {
            int pivot = doPartition(array, startPos, endPos);

            doSort(array, startPos, pivot - 1);
            doSort(array, pivot + 1, endPos);
        }
    }

    private int doPartition(int[] array, int startPos, int rightIndex) {
        int pivot = array[startPos];
        int leftIndex = startPos + 1;

        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < pivot) {
                leftIndex++;
                if (leftIndex > rightIndex)
                    break;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
                if (rightIndex < leftIndex)
                    break;
            }

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        swap(array, startPos, rightIndex);
        return rightIndex;
    }


    private void swap(int[] array, int startPos, int secondPos) {
        int temp = array[startPos];
        array[startPos] = array[secondPos];
        array[secondPos] = temp;
    }
}