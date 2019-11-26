public class QuickSort {

    public void startQuicksort(int[] a, int lo, int hi) {
        MyInsertionTest.shuffle(a, lo, hi);
        quicksort(a, lo, hi);
    }


    public void quicksort(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int sort = sortForReal(a, lo, hi);
        quicksort(a, lo, sort-1);
        quicksort(a, sort+1, hi);
    }

    public int sortForReal(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo;
        int j = hi+1;

        while (true){
            while(a[++i] < pivot) {

                if (i == hi) {
                    break;
                }
            }
            while (pivot < a[--j] ) {

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

    public static void main(String[] args) throws Exception {
       QuickSort q = new QuickSort();
        int[] data = MyInsertionTest.readIntfile("files/smallints"); // Also try "largeints"!
        int N = data.length;    // Change to some smaller number to test on part of array.

        // Look at numbers before sorting, unless there are too many of them.


        long before = System.currentTimeMillis();
        q.startQuicksort(data, 0, N-1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.


        if (MyInsertionTest.isSorted(data, 0, N-1)) {
            System.out.println((after-before) / 1000.0 + " seconds");
        }
    }
}
