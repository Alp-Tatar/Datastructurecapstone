import java.util.ArrayList;
import java.util.List;

/*
 *@author Alp Tatar 300241739
 */

public class NearestNeighborsKD {

    List<Point3D> Neighbors;
    KDTree tree;

    /**
     * Main constructor for the nearest neighbors
     * @param list
     */
    public NearestNeighborsKD(List<Point3D> list) {

        tree = new KDTree();
        KDTree.KDNode treeroot = tree.new KDNode(list.get(0), 0);
        this.tree.setRoot(treeroot); //setting the tree root
        for (int i = 1; i < list.size(); i++) {
            this.tree.insert(list.get(i), tree.getroot(), 0);
        }
    }

    /**
     * Range queary to find neibors
     * @param eps
     * @param p
     * @return neighbors of the point
     */
    public List<Point3D> rangeQuery(double eps, Point3D p) {

        Neighbors = new ArrayList<Point3D>();

        rangeQuery(p, eps, Neighbors, tree.getroot());
        return Neighbors;
    }

    /**
     * Range quearly algoritm polymorphism
     * @param p
     * @param eps
     * @param list
     * @param node
     * @return Null
     */
     private void rangeQuery(Point3D p, double eps, List<Point3D> list, KDTree.KDNode node) {
        if (node == null) {
            return;
        }

        if (p.distance(node.point) < eps) {
            list.add(node.point);
        }

        if (p.get(node.axis) - eps <= node.value) {
            rangeQuery(p, eps, list, node.left);
        }

        if (p.get(node.axis) + eps > node.value) {
            rangeQuery(p, eps, list, node.right);
        }

        return;
    }
}

