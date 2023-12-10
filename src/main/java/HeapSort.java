public class HeapSort implements Algorithm{

    @Override
    public void sort(int[] array) {
        buildTheHeap(array);

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private void buildTheHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    private void heapify(int[] array, int arraySize, int top) {
        int leftChild = 2 * top + 1;
        int rightChild = 2 * top + 2;
        int biggest = top;

        if (leftChild < arraySize && array[leftChild] > array[biggest]) {
            biggest = leftChild;
        }

        if (rightChild < arraySize && array[rightChild] > array[biggest]) {
            biggest = rightChild;
        }

        if (top != biggest) {
            int temp = array[top];
            array[top] = array[biggest];
            array[biggest] = temp;

            heapify(array, arraySize, biggest);
        }
    }

}
