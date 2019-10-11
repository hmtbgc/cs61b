public interface Deque<Item> {
    public int size();
    public void addFirst(Item x);
    public void addLast(Item x);
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
    default public boolean isEmpty() {
        return size() == 0;
    }

}
