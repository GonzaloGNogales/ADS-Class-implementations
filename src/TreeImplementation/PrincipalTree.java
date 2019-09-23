package TreeImplementation;
import DLinkedList.Position;

public class PrincipalTree {
    public static void main (String[] args) {

        Tree<Integer> t = new LinkedTree<>();

        if (t.isEmpty()) {
            System.out.println("The tree is empty." + "\n");
        }

        Position<Integer> r = t.addRoot(8);
        //Position<Integer> brokenR = t.addRoot(3); Method exception test
        Position<Integer> rChild1 = t.add(r, 1);
        Position<Integer> rChild2 = t.add(r, 2);
        Position<Integer> rChild3 = t.add(r, 3);
        Position<Integer> rChild4 = t.add(r, 4);
        Position<Integer> child1Child1 = t.add(rChild1, 5);
        Position<Integer> child1Child2 = t.add(rChild1, 6);
        Position<Integer> child4Child1 = t.add(rChild4, 19);


        System.out.println(t.size() + "\n" + t.isLeaf(child4Child1) + "\n");

    }
}
