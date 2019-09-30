package DLinkedList;

import java.util.Iterator;

public class DoubleLinkedList<E> implements List<E> {
    private int size;
    private DoubleLinkedNode<E> head,tail;
    private class DoubleLinkedNode<E> implements Position<E> {
        private E elem;
        private DoubleLinkedNode<E> next,prev;
        private DoubleLinkedList<E> id;

        public DoubleLinkedNode (E elem, DoubleLinkedNode<E> nxt, DoubleLinkedNode<E> prv, DoubleLinkedList<E> lid) {
            this.elem = elem;
            this.next = nxt;
            this.prev = prv;
            this.id = lid;
        }

        public E getElem () {
            return this.elem;
        }

        public DoubleLinkedList<E> getId () {
            return this.id;
        }

        public DoubleLinkedNode<E> getNext () {
            return this.next;
        }

        public void setNext (DoubleLinkedNode<E> nxt) {
            this.next = nxt;
        }

        public DoubleLinkedNode<E> getPrev () {
            return this.prev;
        }

        public void setPrev (DoubleLinkedNode<E> prv) {
            this.prev = prv;
        }
    }

    //isEmpty O(1)
    @Override
    public boolean isEmpty () {
        return this.size == 0;
    }

    //addLast O(1)
    public Position<E> addLast (E e) {
        DoubleLinkedNode<E> newNode;

        if (this.isEmpty()) {
            newNode = new DoubleLinkedNode<>(e,null,null, this);
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode = new DoubleLinkedNode<>(e,null,this.tail, this);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
        return newNode;
    }

    //Not best implementation of function show O(n)
    @Override
    public void show () {
        if (!this.isEmpty()) {
            DoubleLinkedNode<E> aux = this.head;

            while (aux != null) {
                System.out.println(aux.getElem());
                aux = aux.getNext();
            }
        }
    }

    //size O(1)
    @Override
    public int size () {
        if (!this.isEmpty()) {
            return this.size;
        }

        return 0;
    }

    //get O(1)
    @Override
    public E get () {
        if (!this.isEmpty()) {
            return this.head.getElem();
        }

        return null;
    }

    //get the element from a specific position of the list O(1)
    @Override
    public E get (Position<E> p) throws RuntimeException {
        DoubleLinkedNode<E> node = checkPosition(p);
        return node.getElem();
    }

    //remove O(1)
    @Override
    public E remove (Position<E> p) throws RuntimeException {
        DoubleLinkedNode<E> node = checkPosition(p);
        E elem = node.getElem();

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }
        else if (node == this.head) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        else if (node == this.tail) {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        else {
            DoubleLinkedNode<E> nodePrev = node.getPrev();
            DoubleLinkedNode<E> nodeNext = node.getNext();
            nodePrev.setNext(nodeNext);
            nodeNext.setPrev(nodePrev);
        }

        this.size--;
        return elem;
    }

    //Private method for controlling the state of the position given from the exterior of the operation.
    private DoubleLinkedNode<E> checkPosition (Position<E> p) throws RuntimeException {
        if ((p == null) || !(p instanceof DoubleLinkedNode)) {
            throw new RuntimeException("The position is invalid.");
        }

        DoubleLinkedNode<E> node = (DoubleLinkedNode<E>) p;

        if (node.getId() != this) {
            throw new RuntimeException("The position does not belong to the list.");
        }

        return node;
    }

    //Searches an element inside the list in an inevitably complexity of O(n)
    public Position<E> search (E e) {
        //For searching on a linked list you are forced into O(n).
        return null;
    }

    @Override
    public Iterator<Position<E>> iterator () {
        return null;
    }

}
