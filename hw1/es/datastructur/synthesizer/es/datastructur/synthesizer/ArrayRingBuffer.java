package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;
        public ArrayRingBufferIterator() {
            pos = first;
        }
        public boolean hasNext() {
            return fillCount() < capacity();
        }
        public T next() {
            if (pos + 1 >= capacity()) {
                pos = 0;
            } else {
                pos = pos + 1;
            }
            return rb[pos];
        }
    }

    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.

        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        fillCount = fillCount + 1;
        rb[last] = x;
        last = last + 1;
        if (last >= capacity()) {
            last = 0;
        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        fillCount = fillCount - 1;
        T item = rb[first];
        first = first + 1;
        if (first >= capacity()) {
            first = 0;
        }
        return item;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        return item;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        ArrayRingBuffer<T> thisCopy = this;
        if (other.capacity() != this.capacity()) {
            return false;
        }
        if (other.fillCount() != this.fillCount()) {
            return false;
        }
        while (thisCopy.fillCount() > 0) {
            if (thisCopy.dequeue() != other.dequeue()) {
                return false;
            }
        }
        return true;
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
