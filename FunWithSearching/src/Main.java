import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] numbers = new int[10_000];
    private static int bCount;
    private static int lCount;

    public static void main(String[] args) {

        int itemWanted = 49990;
        randomizeNumbers();
        Arrays.sort(numbers);
        printNumbers();


        System.out.println("Linear search found " + itemWanted + " at index " + linearSearch(itemWanted));
        System.out.println("Linear search count:" + lCount);
        System.out.println("Binary search found " + itemWanted + " at index " + binarySearch(itemWanted));
        System.out.println("Binary search count:" + bCount);
    }


    /**
     *
     * @param itemWanted
     * @return
     */
    private static int binarySearch(int itemWanted) {

        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            bCount++;
            int middle = start + (end - start)/2;

            // if the item we are looking for is in the middle of the array, return it
            if (numbers[middle] == itemWanted)
                return middle;

            // adjust the start index to the middle, if item is greater than the middle number
            if (numbers[middle] < itemWanted)
                start = middle + 1;

            // adjust the end index to the middle, if item is smaller than the middle number
            if (numbers[middle] > itemWanted)
                end = middle - 1;
        }

        return -1; // we didnt find it
    }

    /**
     *
     * @param itemWanted
     * @return
     */
    private static int linearSearch(int itemWanted) {
        for (int i = 0; i < numbers.length; i++) {
            lCount++;
            if (numbers[i] == itemWanted)
                return i;
        }
        return -1;
    }



    private static void randomizeNumbers() {

        Random random = new Random(1500);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(numbers.length * 10);
        }
    }

    /**
     *
     */
    private static void printNumbers() {
        for (int number : numbers) {
            System.out.print(number + "-");
        }
        System.out.println();
    }
}