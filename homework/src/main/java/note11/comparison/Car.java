package note11.comparison;

/**
 * class Car<br/>
 * A car with three objectives : price, year, mileage
 * @author author
 * @since 2014/12/05
 */
public class Car {
    private int price;
    private int year;
    private int mileage;
    public Car(int year, int price, int mileage) {
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString() {
        return "Car(year=" + year + ", price=" + price + ", mileage=" + mileage + ")";
    }
}
