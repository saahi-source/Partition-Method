public class Partition {

    // This method uses the Lomuto partition scheme
    // The pivot is chosen as the last element in the array
    public static int lomutoPartition(int[] arr, int low, int high) {

        // If the array is empty or null, there is nothing to partition
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Set the pivot as the last element
        int pivot = arr[high];

        // i keeps track of where the smaller elements should go
        int i = low - 1;

        // Go through the array from low to high-1
        for (int j = low; j < high; j++) {

            // If current element is less than or equal to pivot
            if (arr[j] <= pivot) {

                // Move i forward
                i++;

                // Swap the current element with element at index i
                swap(arr, i, j);
            }
        }

        // Finally, place the pivot in the correct position
        swap(arr, i + 1, high);

        // Return the index where the pivot ends up
        return i + 1;
    }

    // This method uses the Hoare partition scheme
    // The pivot is chosen as the first element
    public static int hoarePartition(int[] arr, int low, int high) {

        // If the array is empty or null, return -1
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Choose the first element as the pivot
        int pivot = arr[low];

        // i moves from the left side
        int i = low - 1;

        // j moves from the right side
        int j = high + 1;

        // Keep looping until the two pointers meet
        while (true) {

            // Move i to the right until an element >= pivot is found
            do {
                i++;
            } while (arr[i] < pivot);

            // Move j to the left until an element <= pivot is found
            do {
                j--;
            } while (arr[j] > pivot);

            // If pointers cross, partitioning is done
            if (i >= j) {
                return j;
            }

            // Swap the elements at i and j
            swap(arr, i, j);
        }
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
