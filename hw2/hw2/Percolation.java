package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    boolean[][] gird;
    private int size;
    WeightedQuickUnionUF set;
    private int numberOfOpen = 0;
    private int top;
    private int bottem;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N <= 0!");
        }
        gird = new boolean[N][N];
        size = N;
        top = 0;
        bottem = N * N + 1;
        set = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                gird[i][j] = false;
            }
        }
    }

    private int xyTo1D(int row, int col) {
        return row * size + col + 1;
    }

    public void open(int row, int col) {
        validate(row, col);
        if(isOpen(row, col)) {
            return;
        }
        gird[row][col] = true;
        numberOfOpen = numberOfOpen + 1;
        if (row == 0) {
            set.union(top, xyTo1D(row, col));
        }
        if (row == size - 1) {
            set.union(xyTo1D(row, col), bottem);
        }
        if (row > 0 && isOpen(row - 1, col)) {
            set.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if (row < size - 1 && isOpen(row + 1, col)) {
            set.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if (col > 0 && isOpen(row, col - 1)) {
            set.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if (col < size - 1 && isOpen(row, col + 1)) {
            set.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return gird[row][col];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return set.connected(top, xyTo1D(row, col));
    }

    public int numberOfOpenSites() {
        return numberOfOpen;
    }

    public boolean percolates() {
        return set.connected(top, bottem);
    }

    private void validate(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }
    }

    public static void main(String[] args) {

    }
}