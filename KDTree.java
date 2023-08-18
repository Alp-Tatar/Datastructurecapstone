/*
 * @author Alp Tatar 300241739
 */
public class KDTree {

    /**
     *Subclass of the KD Tree
     */
    public class KDNode {
        public Point3D point;
        public int axis;
        public double value;
        public KDNode left;
        public KDNode right;

        /**
         * Origional constructor of the node
         * @param pt
         * @param axis
         */
        public KDNode(Point3D pt, int axis) {
            this.point= pt;
            this.axis= axis;
            this.value= pt.get(axis);
            this.left= this.right= null;
        }
    }

    private KDNode root;

    /**
     *Constructor that is inialized as null if no parameters were given
     */
    public KDTree() {
        this.root = null;
    }

    /**
     * @return root
     */
    public KDNode getroot() {
        return this.root;
    }


    /**
     * @param root
     */
    public void setRoot(KDNode root) {
        this.root = root;
    }




    /**
     * Insets a node into the tree
     * @param p
     * @param node
     * @param axis
     * @return
     */
    public KDNode insert(Point3D p, KDNode node, int axis) {
        int dimesnion = 3;

        if (node == null) {
            node = new KDNode(p, axis);
        }

        else if (p.get(axis) <= node.value) {
            node.left = insert(p, node.left, (axis+1) % dimesnion);
        }

        else {
            node.right = insert(p, node.right, (axis+1) % dimesnion);
        }

        return node;
    }

}