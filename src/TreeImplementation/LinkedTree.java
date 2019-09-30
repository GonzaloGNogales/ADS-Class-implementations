package TreeImplementation;

import DLinkedList.DoubleLinkedList;
import DLinkedList.Position;
import java.util.Iterator;

public class LinkedTree<E> implements Tree<E> {
    private int size;
    private TreeNode<E> root;
    private class TreeNode<E> implements Position<E> {
        private E elem;
        private TreeNode<E> parent;
        private DoubleLinkedList<TreeNode<E>> children;
        private LinkedTree<E> tid;

        public TreeNode (E e, TreeNode<E> p, DoubleLinkedList<TreeNode<E>> l, LinkedTree<E> id) {
            this.elem = e;
            this.parent = p;
            this.children = l;
            this.tid = id;
        }

        public E getElem () {
            return this.elem;
        }

        public TreeNode<E> getParent () {
            return this.parent;
        }

        public void setParent (TreeNode<E> p) {
            this.parent = p;
        }

        public DoubleLinkedList<TreeNode<E>> getChildren () {
            return this.children;
        }

        public LinkedTree<E> getTid () {
            return this.tid;
        }

        public void setTid (LinkedTree<E> id) {
            this.tid = id;
        }
    }

    //O(1)
    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }

    //O(1)
    @Override
    public int size () {
        return this.size;
    }

    //O(1)
    @Override
    public Position<E> root () throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("The tree is empty.");
        }

        return this.root;
    }

    //O(1)
    @Override
    public boolean isLeaf (Position<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren().isEmpty();
    }

    //O(1)
    @Override
    public Position<E> addRoot (E e) throws RuntimeException {
        if (!this.isEmpty()) {
            throw new RuntimeException("The tree has a root already.");
        }

        this.size = 1;
        this.root = new TreeNode<>(e,null, new DoubleLinkedList<>(), this);
        return this.root;
    }

    //O(1)
    @Override
    public Position<E> add (Position<E> p, E e) throws RuntimeException {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(e, parent, new DoubleLinkedList<>(), this);
        DoubleLinkedList<TreeNode<E>> l = parent.getChildren();
        l.addLast(newNode);
        this.size++;
        return newNode;
    }

    //O(1)
    @Override
    public Iterable<? extends Position<E>> children (Position<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren();
    }

    //Review
    public void remove (Position<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        node.setTid(null);

        if (node.getParent() == null) {
            this.root = null;
            this.size = 0;
        }
        else {
            TreeNode<E> parent = node.getParent();
            //parent.getChildren().remove(node);
            Iterator<Position<E>> it = new BreathFirstTreeIterator<>(this);
            int cont = 1;
            while(it.hasNext()) {
                //Continue code here...
            }
        }
    }

    //Iterates the structure with O(n) complexity
    @Override
    public Iterator<Position<E>> iterator () {
        Iterator<Position<E>> it = new BreathFirstTreeIterator<>(this);
        return it;
    }


    //Private method for controlling the state of the position given from the exterior of the operation.
    private TreeNode<E> checkPosition (Position<E> p) throws RuntimeException {
        if ((p == null) || !(p instanceof TreeNode)) {
            throw new RuntimeException("The position is invalid.");
        }

        TreeNode<E> node = (TreeNode<E>) p;

        if (node.getTid() != this) {
            throw new RuntimeException("The position does not belong to the tree.");
        }

        return node;
    }
}
