import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  
/*
 * @author Alp Tatar 300241739
 */
public class Exp2 {

	public static List<Point3D> read(String filename) throws Exception {
	  
		List<Point3D> points= new ArrayList<Point3D>(); 
		double x,y,z;
		Scanner sc = new Scanner(new File(filename));  
		sc.useDelimiter(",|\n|\r");

		// skipping the first line x y z
		sc.next(); sc.next(); sc.next();
	
		// read points
		while (sc.hasNext())  
		{  
			x= Double.parseDouble(sc.next());
			y= Double.parseDouble(sc.next());
			z= Double.parseDouble(sc.next());
			points.add(new Point3D(x,y,z));  
		}   
	
		sc.close();  //closes the scanner  
	
		return points;
	}
	

	public static void main(String args[]) throws Exception {
		String type = args[0];
		double eps = Double.parseDouble(args[1]);
		List<Point3D> pts = Exp2.read(args[2]);
		int step = Integer.parseInt(args[3]);
		NearestNeighborsKD kdneihbors= new NearestNeighborsKD(pts);
		NearestNeighbors linearneibor= new NearestNeighbors(pts);
		
		double sum = 0;

		for (int i = 0; i < pts.size(); i += step) {
			Point3D holder = pts.get(i);
			if (type.equals("kd")) {
				double startTime = System.nanoTime();
				kdneihbors.rangeQuery(eps,holder);
				double endTime = System.nanoTime();
				sum += (endTime - startTime);
			} else if (type.equals("lin")) {
				double startTime = System.nanoTime();
				linearneibor.rangeQuery(holder,eps);
				double endTime = System.nanoTime();
				sum += (endTime - startTime);
			}
		}
		System.out.println("Total time for finding neighbors: " + Double.toString(sum) + "ms");
	}

}