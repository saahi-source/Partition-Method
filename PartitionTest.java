import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PartitionTest {

    // Arrays provided in the assignment
    int[] sortedArray = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
    int[] emptyArray = {};
    int[] randomArray = {84, 3, 7, 1, 9, 6, 2, 5};

    // -------------------- LOMUTO TESTS --------------------

    @Test
    public void testLomutoSortedArray() {

        // Run Lomuto partition on the sorted array
        int pivotIndex = Partition.lomutoPartition(sortedArray, 0, sortedArray.length - 1);

        // Since the pivot is the last element (67), it should stay at the last index
        assertEquals(9, pivotIndex);
    }

    @Test
    public void testLomutoEmptyArray() {

        // Run Lomuto partition on an empty array
        int pivotIndex = Partition.lomutoPartition(emptyArray, 0, emptyArray.length - 1);

        // We expect -1 because there is nothing to partition
        assertEquals(-1, pivotIndex);
    }

    @Test
    public void testLomutoRandomArray() {

        // Run Lomuto partition on the random array
        int pivotIndex = Partition.lomutoPartition(randomArray, 0, randomArray.length - 1);

        int pivot = randomArray[pivotIndex];

        // Check that everything on the left side is smaller or equal to pivot
        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(randomArray[i] <= pivot);
        }

        // Check that everything on the right side is greater or equal to pivot
        for (int i = pivotIndex + 1; i < randomArray.length; i++) {
            assertTrue(randomArray[i] >= pivot);
        }
    }

    // -------------------- HOARE TESTS --------------------

    @Test
    public void testHoareSortedArray() {

        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        // Run Hoare partition
        int pivotIndex = Partition.hoarePartition(arr, 0, arr.length - 1);

        // Just make sure the pivot index is inside the array bounds
        assertTrue(pivotIndex >= 0 && pivotIndex < arr.length);
    }

    @Test
    public void testHoareEmptyArray() {

        // Run Hoare partition on an empty array
        int pivotIndex = Partition.hoarePartition(emptyArray, 0, emptyArray.length - 1);

        // Expect -1 for empty array
        assertEquals(-1, pivotIndex);
    }

    @Test
    public void testHoareRandomArray() {

        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        // Run Hoare partition
        int pivotIndex = Partition.hoarePartition(arr, 0, arr.length - 1);

        int pivot = arr[pivotIndex];

        // Check left side of pivot
        for (int i = 0; i <= pivotIndex; i++) {
            assertTrue(arr[i] <= pivot);
        }

        // Check right side of pivot
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }
}
