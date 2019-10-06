package TreeImplementation;

import java.util.Iterator;

public class PrincipalTree {
    public static void main (String[] args) {

        Tree<Integer> t = new LinkedTree<>();

        if (t.isEmpty()) {
            System.out.println("The tree is empty." + "\n");
        }

        TreePosition<Integer> r = t.addRoot(8);
        //TreePosition<Integer> brokenR = t.addRoot(3); Method exception test
        TreePosition<Integer> rChild1 = t.add(r, 1);
        TreePosition<Integer> rChild2 = t.add(r, 2);
        TreePosition<Integer> rChild3 = t.add(r, 3);
        TreePosition<Integer> rChild4 = t.add(r, 4);
        TreePosition<Integer> child1Child1 = t.add(rChild1, 5);
        TreePosition<Integer> child1Child2 = t.add(rChild1, 6);
        TreePosition<Integer> child4Child1 = t.add(rChild4, 19);
        TreePosition<Integer> child1Child1Child1 = t.add(child1Child1, 27);


        //System.out.println(t.size() + "\n" + t.isLeaf(child4Child1) + "\n");

        for (TreePosition<Integer> p: t) {
            System.out.println(p.getElem() + " ");
        }

    }
}
