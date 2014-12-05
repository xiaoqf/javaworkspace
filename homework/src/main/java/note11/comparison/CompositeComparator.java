package note11.comparison;

import java.util.Comparator;
/**
 * class CompositeComparator<br/>
 * A comparator which can compare two cars with their prices, years, mileages.</br>
 * @author author
 * @since 2014/12/05
 */
public class CompositeComparator implements Comparator<Car> {

    /**
     * sort priority : less year > lower price > less mileage.<br/>
     * for example : Car(year:1, price:3000, mileage 3000) 
     * will be sort at the front of Car(year:2, price:3000, mileage 3000),
     * and Car(year:1, price:2000, mileage 3000) 
     * will be sort at the front of Car(year:1, price:3000, mileage 3000),
     * and Car(year:1, price:3000, mileage 2000) 
     * will be sort at the front of Car(year:1, price:3000, mileage 3000)
     */
    public int compare(Car o1, Car o2) {
        if (o1.getYear() < o2.getYear()) {
            return -1;
        } else if (o1.getYear() > o2.getYear()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getMileage() < o2.getMileage()) {
            return -1;
        } else if (o1.getMileage() > o2.getMileage()) {
            return 1;
        } else {
            return 0;
        }
    }

}
