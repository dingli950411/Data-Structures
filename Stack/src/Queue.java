public interface Queue<E> {


    public E dequeue();

    public void enqueue(E e);

    public E getFront();

    public int getSize();

    public boolean isEmpty();
}
