package DLinkedList;

public class PrincipalDLL {
    public static void main (String[] args) {
        List<Integer> l = new DoubleLinkedList<>();

        if (l.isEmpty()) {
            System.out.println("La lista esta vacia por el momento." + "\n");
        }

        Position<Integer> p1 = l.addLast(1);
        Position<Integer> p2 = l.addLast(2);
        Position<Integer> p3 = l.addLast(3);
        Position<Integer> p4 = l.addLast(4);
        Position<Integer> p5 = l.addLast(5);
        l.show();

        Position<Integer> p6 = l.addLast(6);
        System.out.println("\n");

        System.out.println(p6.getElem() + "\n");

        Integer i = l.remove(p4);
        l.show();
        System.out.println("\n");
    }
}
