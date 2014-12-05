package note11.comparison;

import java.util.Comparator;

/**
 * class MileageComparator<br/>
 * A comparator which can compare two cars with their mileages.</br>
 * @author author
 * @since 2014/12/05
 */
public class MileageComparator implements Comparator<Car> {
    
    /**
     * The car which has a less year will be sort in the front of the list or array
     */
    public int compare(Car o1, Car o2) {
        if(o1.getMileage() < o2.getMileage()) {
            return -1;
        } else if (o1.getMileage() > o2.getMileage()) {
            return 1;
        } else {
            return 0;
        }
    }

}
