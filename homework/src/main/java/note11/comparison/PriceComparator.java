package note11.comparison;

import java.util.Comparator;

/**
 * class PriceComparator<br/>
 * A comparator which can compare two cars with their prices.</br>
 * @author author
 * @since 2014/12/05
 */
public class PriceComparator implements Comparator<Car> {

    /**
     * The car which has a lower price will be sort in the front of the list or array
     */
    public int compare(Car o1, Car o2) {
        if(o1.getPrice() < o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

}
