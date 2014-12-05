package note11.polygon;

/**
 * class Point<br/>
 * A point with a two dimensional coordinate
 * @author author
 * @since 2014/12/05
 */
public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
