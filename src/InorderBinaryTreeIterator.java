import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class InorderBinaryTreeIterator<E> implements Iterator<Position<E>> {
    private Deque<Position<E>> nodeStack = new LinkedList<>();
    private BinaryTree<E> tree;

    public InorderBinaryTreeIterator (BinaryTree<E> t) {
        this.tree = t;
        goToLastLeftNode(t.root());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Position<E> next() {
        return null;
    }

    private void goToLastLeftNode (Position<E> p) {
        nodeStack.addFirst(p);

        while (this.tree.hasLeft()) {
            p = this.tree.left();
        }

        nodeStack.addFirst(p);
    }
}
