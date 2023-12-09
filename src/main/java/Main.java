public class Main {

    public static InsertionSort insertionSort = new InsertionSort();
    public static QuickSort quickSort = new QuickSort();

    public static void main(String[] args) {
        int[] testArray = {3, 13, 7, 8, 2, 8, 9, 1, 5};
        quickSort.sort(testArray);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + (i) + ": " + array[i]);
        }
    }

}