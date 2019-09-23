package TreeImplementation;

import DLinkedList.Position;
import java.util.Iterator;

public interface Tree<E> {
    boolean isEmpty ();
    int size ();
    //Iterator<E> iterator ();
    //Position<E> root ();
    Position<E> add (Position<E>f, E e);
    Position<E> addRoot (E e);
    //Position<E> father (Position<E> p);
    //Iterable<E> children (Position<E> p);
    boolean isLeaf (Position<E> p);
    //boolean isRoot (Position<E> p);
    //E replace (Position<E> p);
}


