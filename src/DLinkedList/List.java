package DLinkedList;

import java.util.Iterator;

public interface List<E> extends Iterable<Position<E>> {
    boolean isEmpty ();
    Position<E> addLast (E e);
    void show ();
    int size ();
    E get ();
    E remove (Position<E> p);
    E get (Position<E> p);
    Position<E> search (E e);
    Iterator<Position<E>> iterator();
}
