
public class Main {
    public static void main(String[] args) {
        int[] numbers = {9, 18, 20, 1, 3, 5};
        System.out.println("Array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        int target = 5;
        System.out.println("Binary Search: target = " + target + ", index of target = " + binarySearch(numbers, target));
    }

    public static int findMaxElementIndex(int[] numbers) {
        int firstIndex = 0;
        int lastIndex = numbers.length-1;
        int middleIndex;
        int maxElementIndex = numbers.length-1;
        while (firstIndex < lastIndex) {
            middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (numbers[middleIndex] >= numbers[maxElementIndex]) {
                firstIndex = middleIndex + 1;
                maxElementIndex = middleIndex;
            }
            else lastIndex = middleIndex;
        }
        return maxElementIndex;
    }

    public static int binarySearch(int[] numbers, int target) {
        int firstIndex, lastIndex, middleIndex;
        if (target >= numbers[0]) {
            firstIndex = 0;
            lastIndex = findMaxElementIndex(numbers);
        } else {
            firstIndex = findMaxElementIndex(numbers) + 1;
            lastIndex = numbers.length-1;
        }

        while (firstIndex < lastIndex) {
            middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (numbers[middleIndex] < target)
                firstIndex = middleIndex + 1;
            else
                lastIndex = middleIndex;
        }
        if (target==numbers[lastIndex])
            return lastIndex;
        else return -1;
    }
}




