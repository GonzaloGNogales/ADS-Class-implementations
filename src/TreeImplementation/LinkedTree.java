package TreeImplementation;

import DLinkedList.DoubleLinkedList;
import DLinkedList.Position;
import java.util.Iterator;

public class LinkedTree<E> implements Tree<E> {
    private int size;
    private TreeNode<E> root;
    private class TreeNode<E> implements Position<E> {
        private E elem;
        private TreeNode<E> father;
        private DoubleLinkedList<TreeNode<E>> children;
        private LinkedTree<E> tid;

        public TreeNode (E e, TreeNode<E> n, DoubleLinkedList<TreeNode<E>> l, LinkedTree<E> id) {
            this.elem = e;
            this.father = n;
            this.children = l;
            this.tid = id;
        }

        public E getElem () {
            return this.elem;
        }

        public TreeNode<E> getFather () {
            return this.father;
        }

        public void setFather (TreeNode<E> father) {
            this.father = father;
        }

        public DoubleLinkedList<TreeNode<E>> getChildren () {
            return children;
        }

        public LinkedTree<E> getTid () {
            return tid;
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
    public Position<E> add (Position<E> f, E e) throws RuntimeException {
        TreeNode<E> father = checkPosition(f);
        TreeNode<E> newNode = new TreeNode<>(e, father, new DoubleLinkedList<>(), this);
        DoubleLinkedList<TreeNode<E>> l = father.getChildren();
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

        if (node.getFather() == null) {
            this.root = null;
            this.size = 0;
        }
        else {
            TreeNode<E> father = node.getFather();
            //father.getChildren().remove(node);
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
