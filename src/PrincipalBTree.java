public class PrincipalBTree {

    public static void main (String[] args) {
        BinaryTree<String> lbtree = new LinkedBinaryTree<>();

        Position<String> root = lbtree.insertRoot("A");
        Position<String> rChildRoot = lbtree.insertRight("B", root);

    }

}
