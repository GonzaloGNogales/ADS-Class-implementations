package TreeImplementation;

import java.util.Iterator;

public interface Tree<E> extends Iterable<TreePosition<E>> {
    boolean isEmpty ();
    int size ();
    TreePosition<E> root ();
    boolean isLeaf (TreePosition<E> p);
    boolean isRoot (TreePosition<E> p);
    TreePosition<E> addRoot (E e);
    TreePosition<E> add (TreePosition<E>f, E e);
    Iterable<? extends TreePosition<E>> children (TreePosition<E> p);
    void remove (TreePosition<E> p);
    Iterator<TreePosition<E>> iterator ();
    TreePosition<E> parent (TreePosition<E> p);
}


