package note11.polygon;

import java.util.List;
/**
 * class RectangleAreaCalculator <br/>
 * A calculator which can calculate the area of a rectangle;
 * @author author
 * @since 2014/12/05
 */
public class RectangleAreaCalculator implements AreaCalculator {

    /**
     * calculate the area of a rectangle
     */
    public float getArea(List<Point> points) {
        // check that if the input points can form a rectangleAreaCalculator
        if(!checkRectangle(points)) {
            throw new RuntimeException("Error! The input points can not be solve as a rectangle.");
        }
        // get the points of th triangle
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);
        // calculate the area of the rectangle
        // hint: rectangle's area is the two times of the triangle made with his any three points 
        return Math.abs((point1.getX() - point2.getX()) * (point1.getY() - point3.getY())
                - (point1.getX() - point3.getX()) * (point1.getY() - point2.getY()));
    }
    
    private boolean checkRectangle(List<Point> points) {
        // in the home work, this check is not required, so that here is a simple check with the number
        // of the rectangle. If you want to check the rationality of the rectangle, please improve this method.
        if(points.size() != 4) {
            return false;
        }
        return true;
    }

}
