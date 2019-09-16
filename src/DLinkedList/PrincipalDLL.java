package DLinkedList;

public class PrincipalDLL {
    public static void main (String[] args) {
        List<Integer> l = new DoubleLinkedList<>();

        if (l.isEmpty()) {
            System.out.println("La lista esta vacia por el momento." + "\n");
        }

        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.show();

        Position<Integer> p = l.addLast(6);
        System.out.println("\n");

        System.out.println(p.getElem() + "\n");
    }
}
