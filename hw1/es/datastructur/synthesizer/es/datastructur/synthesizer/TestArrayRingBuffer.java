package es.datastructur.synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 9; ++i) {
            arb.enqueue(i);
        }
        arb.enqueue(10);
        assertTrue(arb.dequeue() == 0);
        assertTrue(arb.dequeue() == 1);
        assertTrue(arb.dequeue() == 2);
        arb.enqueue(11);
        arb.enqueue(12);
        int[] actual = new int[arb.fillCount()];
        int index = 0;
        while (arb.fillCount() > 0) {
            actual[index] = arb.dequeue();
            index += 1;
        }
        int[] expect = new int[]{3, 4, 5, 6, 7, 8, 10, 11, 12};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void TestforEquals() {
        ArrayRingBuffer<Integer> a = new ArrayRingBuffer<>(3);
        ArrayRingBuffer<Integer> b = new ArrayRingBuffer<>(3);
        for (int i = 0; i < 3; ++i) {
            a.enqueue(i);
            b.enqueue(i);
        }
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }
}
