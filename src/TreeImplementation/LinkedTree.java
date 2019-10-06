package TreeImplementation;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedTree<E> implements Tree<E> {
    private int size;
    private TreeNode<E> root;
    private class TreeNode<E> implements TreePosition<E> {
        private E elem;
        private TreeNode<E> parent;
        private LinkedList<TreeNode<E>> children;
        private LinkedTree<E> tid;
        public TreeNode (E e, TreeNode<E> p, LinkedList<TreeNode<E>> l, LinkedTree<E> id) {
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

        public LinkedList<TreeNode<E>> getChildren () {
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
    public TreePosition<E> root () throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("The tree is empty.");
        }

        return this.root;
    }

    //O(1)
    @Override
    public boolean isLeaf (TreePosition<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren().isEmpty();
    }

    //O(1)
    @Override
    public boolean isRoot (TreePosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node.getParent() == null);
    }

    //O(1)
    @Override
    public TreePosition<E> addRoot (E e) throws RuntimeException {
        if (!this.isEmpty()) {
            throw new RuntimeException("The tree has a root already.");
        }

        this.size = 1;
        this.root = new TreeNode<>(e,null, new LinkedList<>(), this);
        return this.root;
    }

    //O(1)
    @Override
    public TreePosition<E> add (TreePosition<E> p, E e) throws RuntimeException {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(e, parent, new LinkedList<>(), this);
        LinkedList<TreeNode<E>> l = parent.getChildren();
        l.addLast(newNode);
        this.size++;
        return newNode;
    }

    //O(1)
    @Override
    public Iterable<? extends TreePosition<E>> children (TreePosition<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren();
    }

    //Review
    public void remove (TreePosition<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        node.setTid(null);

        if (node.getParent() == null) {
            this.root = null;
            this.size = 0;
        }
        else {
            TreeNode<E> parent = node.getParent();
            //parent.getChildren().remove(node);
            Iterator<TreePosition<E>> it = new BreadthFirstTreeIterator<>(this);
            int cont = 1;
            while(it.hasNext()) {
                //Continue code here...
            }
        }
    }

    //Get an iterator that iterates the structure with O(n) complexity
    @Override
    public Iterator<TreePosition<E>> iterator () {
        Iterator<TreePosition<E>> it = new BreadthFirstTreeIterator<>(this);
        return it;
    }

    //O(1)
    @Override
    public TreePosition<E> parent (TreePosition<E> p) throws RuntimeException {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> parentNode = node.getParent();

        if (parentNode == null)
            throw new RuntimeException("This node has no parent.");

        return parentNode;
    }

    //Private method for controlling the state of the position given from the exterior of the operation.
    private TreeNode<E> checkPosition (TreePosition<E> p) throws RuntimeException {
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
