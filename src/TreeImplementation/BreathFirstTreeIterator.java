package TreeImplementation;

import DLinkedList.Position;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstTreeIterator<E> implements Iterator<Position<E>> {
    private Queue<Position<E>> nodeQueue;
    private Tree<E> tree;

    public BreathFirstTreeIterator (Tree<E> t) {
        this.tree = t;
        this.nodeQueue = new LinkedList<>();
        this.nodeQueue.add(this.tree.root());
    }

    public BreathFirstTreeIterator (Tree<E> t, Position<E> p) {
        this.tree = t;
        this.nodeQueue = new LinkedList<>();
        this.nodeQueue.add(p);
    }

    @Override
    public boolean hasNext () {
        return (!nodeQueue.isEmpty());
    }

    @Override
    public Position<E> next () {
        Position<E> pAux = this.nodeQueue.poll(); //pollFirst()

        for (Position<E> node: this.tree.children(pAux)) {
            this.nodeQueue.add(node);
        }

        return pAux;
    }
}
