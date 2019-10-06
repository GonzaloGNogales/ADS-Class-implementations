package TreeImplementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTreeIterator<E> implements Iterator<TreePosition<E>> {
    private Queue<TreePosition<E>> nodeQueue;
    private Tree<E> tree;

    public BreadthFirstTreeIterator(Tree<E> t) {
        this.tree = t;
        this.nodeQueue = new LinkedList<>();
        this.nodeQueue.add(this.tree.root());
    }

    public BreadthFirstTreeIterator(Tree<E> t, TreePosition<E> p) {
        this.tree = t;
        this.nodeQueue = new LinkedList<>();
        this.nodeQueue.add(p);
    }

    @Override
    public boolean hasNext () {
        return (!nodeQueue.isEmpty());
    }

    @Override
    public TreePosition<E> next () {
        TreePosition<E> pAux = this.nodeQueue.poll(); //pollFirst()

        for (TreePosition<E> node: this.tree.children(pAux)) {
            this.nodeQueue.add(node);
        }

        return pAux;
    }
}

