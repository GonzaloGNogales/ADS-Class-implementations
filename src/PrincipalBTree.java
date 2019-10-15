import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class PrincipalBTree {

    public static void main (String[] args) {
        BinaryTree<String> lbtree = new LinkedBinaryTree<>();

        Position<String> root = lbtree.insertRoot("A");
        Position<String> Child1 = lbtree.insertLeft("B", root);
        Position<String> Child2 = lbtree.insertRight("C", root);
        Position<String> Child11 = lbtree.insertLeft("D", Child1);
        Position<String> Child12 = lbtree.insertRight("E", Child1);
        Position<String> Child21 = lbtree.insertLeft("F", Child2);
        Position<String> Child22 = lbtree.insertRight("G", Child2);
        Position<String> Child111 = lbtree.insertLeft("X", Child11);
        Position<String> Child222 = lbtree.insertRight("Z", Child22);

        System.out.print("Inorder iteration of custom binary tree: ");
        for (Position<String> s: lbtree) {
            System.out.print(s.getElem());
            System.out.print(" ");
        }

    }

}
