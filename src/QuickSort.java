import java.util.Arrays;

public class QuickSort {

    public void startQuicksort(int[] a, int lo, int hi) {
        quickSortLo(a, lo, hi);
    }


    public void quickSortLo(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int sort = sortForRealLo(a, lo, hi);
        quickSortLo(a, lo, sort - 1);
        quickSortLo(a, sort + 1, hi);
    }

    public int sortForRealLo(int[] a, int lo, int hi) {
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
    public void quickSortHi(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int sort = sortForRealHi(a, lo, hi);
        quickSortHi(a, lo, sort - 1);
        quickSortHi(a, sort + 1, hi);
    }

    public int sortForRealHi(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        a[hi] = a[i];
        a[i] = pivot;

        return i;
    }

    private void testLoWorstCondition() {
        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/largeints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = 70000;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.


        Arrays.sort(data);
        for (int i = 0; i < data.length / 2; ++i) {
            int temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }
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
            data = MyInsertionTest.readIntfile("files/largeints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = 70000;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.

        long before = System.currentTimeMillis();
        startQuicksort(data, 0, N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N - 1)) {
            System.out.println((after - before) / 1000.0 + " seconds");
        }
    }

    private void testHiDefault() {

        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/largeints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = 30000;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.


        long before = System.currentTimeMillis();
        quickSortHi(data, 0, N-1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N-1)) {
            System.out.println((after-before) / 1000.0 + " seconds");
        }
    }

    private void testHiWorst() {

        int[] data = new int[0]; // Also try "largeints"!
        try {
            data = MyInsertionTest.readIntfile("files/largeints");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int N = 30000;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.


        Arrays.sort(data);
        long before = System.currentTimeMillis();
        quickSortHi(data, 0, N-1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N-1)) {
            System.out.println((after-before) / 1000.0 + " seconds");
        }
    }




    public static void main(String[] args) throws Exception {
        QuickSort q = new QuickSort();
        System.out.println("Default condition, low:");
        q.testLoDefault();
        System.out.println("Worst condition, low:");
        q.testLoWorstCondition();
        System.out.println("Default condition, high:");
        q.testHiDefault();
        System.out.println("Worst condition, high:");
        q.testHiWorst();
    }
}
