import javafx.geometry.Pos;

import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private int size;
    private BinaryNode<E> root;
    private class BinaryNode<E> implements Position<E> {
        private E elem;
        private BinaryNode<E> parent, leftChild, rightChild;
        private LinkedBinaryTree<E> myTree;

        public BinaryNode (E e, BinaryNode<E> p, BinaryNode<E> lC, BinaryNode<E> rC, LinkedBinaryTree<E> tid) {
            this.elem = e;
            this.parent = p;
            this.leftChild = lC;
            this.rightChild = rC;
            this.myTree = tid;
        }

        @Override
        public E getElem() {
            return this.elem;
        }

        public BinaryNode<E> getParent() {
            return this.parent;
        }

        public BinaryNode<E> getLeftChild() {
            return this.leftChild;
        }

        public BinaryNode<E> getRightChild() {
            return this.rightChild;
        }

        public LinkedBinaryTree<E> getMyTree() {
            return this.myTree;
        }

        public void setParent(BinaryNode<E> parent) {
            this.parent = parent;
        }

        public void setLeftChild(BinaryNode<E> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(BinaryNode<E> rightChild) {
            this.rightChild = rightChild;
        }

        public void setMyTree(LinkedBinaryTree<E> myTree) {
            this.myTree = myTree;
        }
    }

    //O(1)
    @Override
    public boolean isEmpty () {
        return (this.size == 0);
    }

    //O(1)
    @Override
    public Position<E> parent (Position<E> p) throws RuntimeException {
        BinaryNode<E> node = checkPosition(p);
        BinaryNode<E> parent = node.getParent();
        if (parent == node) {
            throw new RuntimeException("The Node has no parent.");
        }
        return parent;
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
    public Position<E> left () throws RuntimeException {
        return this.root.getLeftChild();
    }

    //O(1)
    @Override
    public boolean hasLeft () {
        return (this.root.getLeftChild() != null);
    }

    //O(1)
    @Override
    public Position<E> insertRoot (E e) {
        BinaryNode<E> newNode = new BinaryNode<>(e,null,null,null,this);
        this.root = newNode;
        this.size++;

        return newNode;
    }

    //O(1)
    @Override
    public Position<E> insertRight (E e, Position<E> parent) throws RuntimeException {
        //Declaration
        BinaryNode<E> node = checkPosition(parent);
        BinaryNode<E> rightNode = node.getRightChild();

        //Comprobation
        if (rightNode != null) {
            throw new RuntimeException("Node already has a right child.");
        }

        //Insertion
        BinaryNode<E> newNode = new BinaryNode<>(e,node,null,null,this);
        node.setRightChild(newNode);
        this.size++;

        //Returning
        return newNode;
    }

    //O(1)
    @Override
    public Position<E> insertLeft (E e, Position<E> parent) throws RuntimeException {
        //Declaration
        BinaryNode<E> node = checkPosition(parent);
        BinaryNode<E> leftNode = node.getLeftChild();

        //Comprobation
        if (leftNode != null) {
            throw new RuntimeException("Node already has a left child.");
        }

        //Insertion
        BinaryNode<E> newNode = new BinaryNode<>(e,node,null,null,this);
        node.setLeftChild(newNode);
        this.size++;

        //Returning
        return newNode;
    }

    //O(1)
    @Override
    public Position<E> sibling (Position<E> p) throws RuntimeException {
        //Declaration and Checking
        BinaryNode<E> node = checkPosition(p);
        BinaryNode<E> parent = node.getParent(); //this.getParent(p);  accede de forma interna en el árbol.
        BinaryNode<E> siblingNode;

        //Sibling node catcher algorithm
        if (parent != null) {
            BinaryNode<E> leftNode = parent.getLeftChild();
            if (node == leftNode) {
                siblingNode = parent.getRightChild();
            }
            else {
                siblingNode = parent.getLeftChild();
            }
        }
        else {
            throw new RuntimeException("The node has no siblings because it is the root of the tree.");
        }

        //Returning condition
        if (siblingNode != null) {
            return siblingNode;
        }
        else {
            throw new RuntimeException("The sibling of the node is null.");
        }
    }

    //O(1)
    @Override
    public void remove (Position<E> p) throws RuntimeException {
        BinaryNode<E> node = checkPosition(p);
        BinaryNode<E> left = node.getLeftChild();
        BinaryNode<E> right = node.getRightChild();

        if ((left != null) && (right != null)) {
            throw new RuntimeException("The node has 2 children and cannot be removed.");
        }

        BinaryNode<E> child;

        if (left != null) {
            child = left;
        }
        else if (right != null) {
            child = right;
        }
        else {
            child = null;
        }

        if (this.root == node) {
            if (child != null) {
                child.setParent(null);
            }
            this.root = child;
        }
        else {
            BinaryNode<E> parent = node.getParent();
            if (parent.getLeftChild() == node) {
                parent.setLeftChild(child);
            }
            else {
                parent.setRightChild(child);
            }

            if (child != null) {
                child.setParent(parent);
            }
        }

        node.setMyTree(null);
        this.size--;
    }

    //Private method for controlling the state of the position given from the exterior of the operation.
    private BinaryNode<E> checkPosition (Position<E> p) throws RuntimeException {
        if ((p == null) || !(p instanceof BinaryNode)) {
            throw new RuntimeException("The position is invalid.");
        }

        BinaryNode<E> node = (BinaryNode<E>) p;

        if (node.getMyTree() != this) {
            throw new RuntimeException("The position does not belong to the tree.");
        }

        return node;
    }

    //Iterator method that internally iterates in the upgraded for call.
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
