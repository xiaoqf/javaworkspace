package note11.polygon;

import java.util.List;
/**
 * class TriangleAreaCalc <br/>
 * A calculator which can calculate the area of a triangle;
 * @author author
 * @since 2014/12/05
 */
public class TriangleAreaCalc implements AreaCalculator{

    /**
     * calculate the area of a triangle
     */
    public float getArea(List<Point> points) {
        if (points.size() != 3) {
            throw new RuntimeException("Error! The input points can not be solve as a triangle.");
        }
        // get the points of th triangle
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);
        // calculate the area of the triangle
        return Math.abs((point1.getX() - point2.getX()) * (point1.getY() - point3.getY())
                - (point1.getX() - point3.getX()) * (point1.getY() - point2.getY())) / 2;
    }
}
