import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InorderBinaryTreeIterator<E> implements Iterator<Position<E>> {
    private Deque<Position<E>> nodeStack = new LinkedList<>();
    private BinaryTree<E> tree;

    //Constructor for the iterator
    public InorderBinaryTreeIterator (BinaryTree<E> t) {
        this.tree = t;
        goToLastLeftNode(t.root());
    }

    //hasNext method consists on just asking the stack if it's empty
    @Override
    public boolean hasNext () {
        return (!nodeStack.isEmpty());
    }

    //Key method of the iterator that takes the next element to manipulate from the stack and returns it
    @Override
    public Position<E> next () {
        Position<E> aux = nodeStack.removeFirst();

        if (this.tree.hasRight(aux)) {
            goToLastLeftNode(this.tree.right(aux));
        }

        return aux;
    }

    //Auxiliar method that positions the next left node to visit in the top of the stack
    private void goToLastLeftNode (Position<E> p) {
        nodeStack.addFirst(p);

        while (this.tree.hasLeft(p)) {
            p = this.tree.left(p);
            nodeStack.addFirst(p);
        }
    }

    //No need to implement.
    @Override
    public void remove () {
        throw new UnsupportedOperationException("Not implemented in Java.");
    }

}
