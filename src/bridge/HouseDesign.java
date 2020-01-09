package bridge;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class HouseDesign implements BuildingDesign {
    double width, length;
    int floorNumber;

    HouseDesign(double width, double length, int floorNumber) {
        this.width = width;
        this.length = length;
        this.floorNumber = floorNumber;
    }

    @Override
    public double computerArea() {
        return width * length * floorNumber;
    }
}
