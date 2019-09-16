package DLinkedList;

public class DoubleLinkedList<E> implements List<E> {
    private int size;
    private DoubleLinkedNode<E> head,tail;
    private class DoubleLinkedNode<E> implements Position<E>{
        private E elem;
        private DoubleLinkedNode<E> next,prev;

        public DoubleLinkedNode (E elem, DoubleLinkedNode nxt, DoubleLinkedNode prv) {
            this.elem = elem;
            this.next = nxt;
            this.prev = prv;
        }

        public E getElem () {
            return this.elem;
        }

        public DoubleLinkedNode<E> getNext () {
            return this.next;
        }

        public void setNext (DoubleLinkedNode nxt) {
            this.next = nxt;
        }

        public DoubleLinkedNode<E> getPrev () {
            return this.prev;
        }
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    public Position<E> addLast (E e) {
        DoubleLinkedNode<E> newNode;

        if (this.isEmpty()) {
            newNode = new DoubleLinkedNode<>(e,null,null);
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode = new DoubleLinkedNode<>(e,null,this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
        return newNode;
    }

    public void show () {
        if (!this.isEmpty()) {
            DoubleLinkedNode<E> aux = this.head;

            while (aux != null) {
                System.out.println(aux.getElem());
                aux = aux.getNext();
            }
        }
    }

    public int size () {
        if (!this.isEmpty()) {
            return this.size;
        }

        return 0;
    }

    public E get () {
        if (!this.isEmpty()) {
            return this.head.getElem();
        }

        return null;
    }

}
