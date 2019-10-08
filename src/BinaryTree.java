public interface BinaryTree<E> extends Iterable<E> {
    boolean isEmpty ();
    Position<E> parent (Position<E> p);
    Position<E> root ();
    Position<E> left ();
    boolean hasLeft ();
    Position<E> insertRoot (E e);
    Position<E> insertRight (E e, Position<E> parent);
    Position<E> insertLeft (E e, Position<E> parent);
    Position<E> sibling (Position<E> p);
    void remove (Position<E> p);
}
