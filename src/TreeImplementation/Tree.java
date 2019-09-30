package TreeImplementation;

import DLinkedList.Position;
import java.util.Iterator;

public interface Tree<E> extends Iterable<Position<E>> {
    boolean isEmpty ();
    int size ();
    Iterator<Position<E>> iterator ();
    Position<E> root ();
    Position<E> add (Position<E>f, E e);
    Position<E> addRoot (E e);
    //Position<E> father (Position<E> p);
    Iterable<? extends Position<E>> children (Position<E> p);
    boolean isLeaf (Position<E> p);
    //boolean isRoot (Position<E> p);
    void remove (Position<E> p);
}


