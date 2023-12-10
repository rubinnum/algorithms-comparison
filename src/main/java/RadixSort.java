public class RadixSort implements Algorithm {

    @Override
    public void sort(int[] array) {
        int maxNumber = getMaxNumber(array);
        int numberOfDigits = getNumberOfDigits(maxNumber);

        for (int i = 1; i <= numberOfDigits; i++) {
            countSort(array, i);
        }
    }

    private void countSort(int[] array, int certainDigit) {
        int[] pos = new int[10];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int decNumber = getValueOfCertainDigit(array[i], certainDigit);
            pos[decNumber]++;
        }

        for (int i = 1; i < 10; i++) {
            pos[i] += pos[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int decNumber = getValueOfCertainDigit(array[i], certainDigit);
            output[--pos[decNumber]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    private int getValueOfCertainDigit(int number, int certainDigit) {
        int valueOfDigit = 0;
        for (int i = 0; i < certainDigit; i++) {
            valueOfDigit = number % 10;
            number /= 10;
        }
        return valueOfDigit;
    }

    private int getNumberOfDigits(int number) {
        int numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits++;
            number /= 10;
        }
        return numberOfDigits;
    }

    private int getMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
