public class MergeSort {

    public void mergeSort(int[] a, int lo, int hi) {
        int[]aux = new int[a.length];

        mergeSort(a, aux, lo, hi);
    }

    public void mergeSort(int[] a, int[] aux, int lo, int hi){
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a,aux,lo,mid);
        mergeSort(a,aux,mid + 1,hi);
        merge(a,aux,lo,mid,hi);

    }
    public void merge(int[] a,int[] aux,int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++){
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid){
                a[k] = aux[j];
                j++;
            }
            else if(j > hi){
                a[k] = aux[i];
                i++;
            }
            else if(aux[i] < aux[j]){
                a[k] = aux[i];
                i++;
            }
            else{
                a[k] = aux[j];
                j++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        MergeSort m = new MergeSort();
        int[] data = MyInsertionTest.readIntfile("files/largeints"); // Also try "largeints"!
        int N = data.length;    // Change to some smaller number to test on part of array.


        // Look at numbers before sorting, unless there are too many of them.
        if (N <= 1000) {
            for (int i = 0; i < N; i++) { System.out.print(data[i]+" "); }
            System.out.print("\n\n");
        }

        long before = System.currentTimeMillis();
          m.mergeSort(data,0,N - 1);
        long after = System.currentTimeMillis();

        // Look at numbers after sorting, unless there are too many of them.
        if (N <= 1000) {
            for (int i = 0; i < N; i++) { System.out.print(data[i]+" "); }
            System.out.print("\n");
        }

        if (MyInsertionTest.isSorted(data, 0, N-1)) {
            System.out.println((after-before) / 1000.0 + " seconds");
        }
    }

}
