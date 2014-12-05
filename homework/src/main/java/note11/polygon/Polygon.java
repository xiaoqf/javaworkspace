package note11.polygon;

import java.util.List;

/**
 * class Polygon
 * @author author
 * @since 2014/12/05
 */
public class Polygon {
    
    private List<Point> points;
    
    private AreaCalculator areaCalc;
    
    /**
     * construct a new polygon
     * @param points The points of this polygon 
     * @param areaCalc The calculator of this polygon
     */
    public Polygon(List<Point> points, AreaCalculator areaCalc) {
        this.points = points;
        this.areaCalc = areaCalc;
    }
    
    /**
     * set the calculator of this polygon
     * 
     * @param areaCalc The area calculator
     */
    public void setAreaCalc(AreaCalculator areaCalc) {
        this.areaCalc = areaCalc;
    }
    
    /**
     * add a new point to the polygon
     * 
     * @param point new Point
     */
    public void addPoint(Point point) {
        points.add(point);
    }
    
    /**
     * calculate the area of the polygon
     * 
     * @return the area
     */
    public float getArea() {
        return areaCalc.getArea(points);
    }
}
