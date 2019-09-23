package TreeImplementation;

import DLinkedList.DoubleLinkedList;
import DLinkedList.Position;

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
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    public int size () {
        return this.size;
    }

    public boolean isLeaf (Position<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren().isEmpty();
    }

    public Position<E> addRoot (E e) throws RuntimeException {
        if (!this.isEmpty()) {
            throw new RuntimeException("The tree has a root already.");
        }

        this.size = 1;
        this.root = new TreeNode<>(e,null, new DoubleLinkedList<>(), this);
        return this.root;
    }

    public Position<E> add (Position<E> f, E e) throws RuntimeException {
        TreeNode<E> father = checkPosition(f);
        TreeNode<E> newNode = new TreeNode<>(e, father, new DoubleLinkedList<>(), this);
        DoubleLinkedList<TreeNode<E>> l = father.getChildren();
        l.addLast(newNode);
        this.size++;
        return newNode;
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
