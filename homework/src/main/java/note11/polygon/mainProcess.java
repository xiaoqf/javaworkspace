package note11.polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * main process
 * @author author
 *
 */
public class mainProcess {

    /**
     * main process
     * @param args
     */
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        // initialize the points of the triangle
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(0, 4));
        Polygon polygon = new Polygon(points, new TriangleAreaCalc());
        System.out.println("the area of triangle:" + points + " is " +polygon.getArea());
        
        // Change the triangle into a rectangle with the strategy design pattern
        polygon.addPoint(new Point(3, 4));
        polygon.setAreaCalc(new RectangleAreaCalculator());
        
        System.out.println("the area of rectangle:" + points + " is " +polygon.getArea());
    }

}
