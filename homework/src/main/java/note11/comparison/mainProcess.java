package note11.comparison;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Car> carLst = new ArrayList<Car>();
        carLst.add(new Car(2, 3000, 20000));
        carLst.add(new Car(2, 3500, 30000));
        carLst.add(new Car(1, 3000, 25000));
        carLst.add(new Car(3, 2500, 15000));
        carLst.add(new Car(4, 2000, 20000));
        
        System.out.println("before sort:" + carLst);
        Collections.sort(carLst, new YearComparator());
        System.out.println("after sort by year:" + carLst);
        Collections.sort(carLst, new PriceComparator());
        System.out.println("after sort by price:" + carLst);
        Collections.sort(carLst, new MileageComparator());
        System.out.println("after sort by mileage:" + carLst);
        Collections.sort(carLst, new CompositeComparator());
        System.out.println("after sort by all objectives:" + carLst);
    }

}
