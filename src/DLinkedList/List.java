package DLinkedList;

public interface List<E> {
    boolean isEmpty();
    Position<E> addLast (E e);
    void show ();
    int size ();
    E get ();
    E remove (Position<E> p);
    E get (Position<E> p);
    Position<E> search (E e);
}
