import java.util.Random;

public class QuickSort {

    public void startQuicksort(int[] a, int lo, int hi) {
        quickSort(a, lo, hi);
    }


    public void quickSort(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int sort = sortForReal(a, lo, hi);
        quickSort(a, lo, sort - 1);
        quickSort(a, sort + 1, hi);
    }

    public int sortForReal(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (a[++i] < pivot) {

                if (i == hi) {
                    break;
                }
            }
            while (pivot < a[--j]) {

                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void testHiDefault(){
        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/smallints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = data.length;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.

        int temp = data[N-1];
        data[N-1] = data[0];
        data[0] = temp;

        long before = System.currentTimeMillis();
        startQuicksort(data, 0, N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N - 1)) {
            System.out.println((after - before) / 1000.0 + " seconds");
        }
    }

    private void testLoDefault() {
        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/smallints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = data.length;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.

        long before = System.currentTimeMillis();
        startQuicksort(data, 0, N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N - 1)) {
            System.out.println((after - before) / 1000.0 + " seconds");
        }
    }

    private void testMiddleDefault() {
        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/smallints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = data.length;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.

        int temp = data[(N/2)-1];
        data[(N/2)-1] = data[0];
        data[0] = temp;

        long before = System.currentTimeMillis();
        startQuicksort(data, 0, N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N - 1)) {
            System.out.println((after - before) / 1000.0 + " seconds");
        }
    }

    private void testRandomDefault() {
        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/smallints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = data.length;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.

        Random rand = new Random();
        int randomPivot = rand.nextInt(N-1);
        int temp = data[randomPivot];
        data[randomPivot] = data[0];
        data[0] = temp;

        long before = System.currentTimeMillis();
        startQuicksort(data, 0, N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N - 1)) {
            System.out.println((after - before) / 1000.0 + " seconds");
        }
    }



    public static void main(String[] args) throws Exception {
        QuickSort q = new QuickSort();
        System.out.println("pivot - low:");
        q.testLoDefault();
        System.out.println("pivot - high:");
        q.testHiDefault();
        System.out.println("pivot - middle:");
        q.testMiddleDefault();
        System.out.println("pivot - random");
        q.testRandomDefault();

    }
}
