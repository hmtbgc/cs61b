public class mergeSort {
    private int[] unsorted;

    public mergeSort(int[] inputArray) {
        int n = inputArray.length;
        unsorted = new int[n];
        System.arraycopy(inputArray, 0, unsorted, 0, n);
    }

    private int[] union(int[] first, int[] second) {
        int p1 = 0;
        int p2 = 0;
        int totnum = 0;
        int length1 = first.length;
        int length2 = second.length;
        int[] unionArray = new int[length1 + length2];
        while (p1 < length1 && p2 < length2) {
            if (first[p1] <= second[p2]) {
                unionArray[totnum] = first[p1];
                totnum = totnum + 1;
                p1 = p1 + 1;
            } else {
                unionArray[totnum] = second[p2];
                totnum = totnum + 1;
                p2 = p2 + 1;
            }
        }
        if (p1 == length1 && p2 < length2) {
            System.arraycopy(second, p2, unionArray, p1 + p2, length2 - p2);
        } else if (p2 == length2 && p1 < length1) {
            System.arraycopy(first, p1, unionArray, p2 + p1, length1 - p1);
        } else {
            return unionArray;
        }
        return unionArray;
    }

    public void mergesort(int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergesort(lo, mid);
        mergesort(mid + 1, hi);
        int[] first = new int[mid - lo + 1];
        int[] second = new int[hi - mid];
        System.arraycopy(unsorted, lo, first, 0, mid - lo + 1);
        System.arraycopy(unsorted, mid + 1, second, 0, hi - mid);
        int[] unionArray = union(first, second);
        assert unionArray.length == hi - lo + 1;
        System.arraycopy(unionArray, 0, unsorted, lo, hi - lo + 1);
    }

    public void printSorted() {
        for (int i = 0; i < unsorted.length; ++i) {
            System.out.print(unsorted[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{0, 6, 4, 3, 7, 8, 2, 10, 9};
        mergeSort method = new mergeSort(inputArray);
        method.mergesort(0, inputArray.length - 1 );
        method.printSorted();
    }
}
