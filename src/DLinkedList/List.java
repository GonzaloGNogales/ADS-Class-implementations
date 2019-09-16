package DLinkedList;

public interface List<E> {
    boolean isEmpty();
    Position<E> addLast (E e);
    void show ();
    int size ();
    E get ();
}
