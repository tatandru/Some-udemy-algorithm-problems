package algorithms;

public class Algorithm {

    public void buildLayer(int height) {
        if (height == 0) return;

        System.out.println(height);
        buildLayer(height - 1);
    }

    public int factorial(int accumulator, int n) {
        if (n == 1) return accumulator;
        return factorial(accumulator * n, n - 1);
    }

    public int calculateFactorial(int n) {
        return factorial(1, n);
    }

    public int greatestCommonDivisorIterative(int firstNumber, int secondNumber) {

        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }

        return firstNumber;
    }

    public int greatestCommonDivisorRecursive(int firstNumber, int secondNumber) {
        if (secondNumber == 0) return firstNumber;

        return greatestCommonDivisorRecursive(secondNumber, firstNumber % secondNumber);
    }

    public void fibonacci(int n) {

        if (n < 1) {
            return;
        }
        System.out.println(0 + " ");
        int lastNumber = 1;
        int secondToLast = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(lastNumber);

            int a = lastNumber + secondToLast;
            secondToLast = lastNumber;
            lastNumber = a;


        }

    }

    public Algorithm() {
    }

    private int[] array;

    public Algorithm(int[] array) {
        this.array = array;
    }

    public int linearSearch(int item) {

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == item)
                return i;
        }
        return -1;


    }

    private int binarySearch(int startIndex, int endIndex, int item) {
        if (endIndex < startIndex) {
            System.out.println("Not present in the array");
            return -1;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        if (item == array[middleIndex]) {
            return middleIndex;
        } else if (item < array[middleIndex]) {
            return binarySearch(startIndex, middleIndex - 1, item);
        } else return binarySearch(middleIndex + 1, endIndex, item);
    }

    public int binarySearch(int item) {
        return binarySearch(0, array.length - 1, item);
    }


    public void towerOfHanoi(int n, char startRod, char auxRod, char endRod) {
        if (n == 1) {
            System.out.println("Plalte 1 from " + startRod + " to " + endRod);
            return;
        }
        towerOfHanoi(n-1,startRod,endRod,auxRod);
        System.out.println("Plate "+n+" from "+startRod+" to "+endRod);
        towerOfHanoi(n-1,auxRod,startRod,endRod);

    }

}
