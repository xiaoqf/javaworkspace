package note11.polygon;

import java.util.List;
/**
 * interface TriangleAreaCalc <br/>
 * A calculator which can calculate the area of a polygon if you have equipped the getArea method.
 * @author author
 * @since 2014/12/05
 */
public interface AreaCalculator {

    /**
     * calculate the area of the polygon
     * 
     * @return the area
     */
    float getArea(List<Point> points);
}
