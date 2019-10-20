public class binarySearch {

    public static int find(int[] sorted, int numberToFind, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (sorted[mid] == numberToFind) {
            return mid;
        }
        if (sorted[mid] > numberToFind) {
            return find(sorted, numberToFind, lo, mid - 1);
        } else {
            return find(sorted, numberToFind, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        int[] sorted = new int[]{2, 3, 4, 7, 8, 9, 10};
        int hi = sorted.length - 1;
        int lo = 0;
        System.out.println(find(sorted, 1, lo, hi));
        System.out.println(find(sorted, 3, lo, hi));
        System.out.println(find(sorted, 2, lo, hi));
        System.out.println(find(sorted, 10, lo, hi));
    }
}
