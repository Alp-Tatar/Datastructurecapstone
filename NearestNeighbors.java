/*
 * Linear neighbors search
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
 * @author Alp Tatar 300241739
*/ 
import java.util.List;
import java.util.ArrayList;

public class NearestNeighbors {

  protected List<Point3D> points;

  /**
   * @param points
   */
  // construct alongside list of points
  public NearestNeighbors(List<Point3D> points) {
       
    this.points= points; 
  }

  /**
   * @param p
   * @param eps
   * @return neighbors
   */
  // gets the neighbors of p (at a distance less than eps)
  public List<Point3D> rangeQuery(Point3D p, double eps) {

    // empty list to contain the neighbors
    List<Point3D> neighbors= new ArrayList<Point3D>(); 

    for (Point3D point: points) {

       if (p.distance(point) < eps) {
		   neighbors.add(point);
	   }
    }
	
    return neighbors;
  }  
}
