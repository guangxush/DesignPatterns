package bridge;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class BuildingCost extends ArchitectureCost {

    public BuildingCost(BuildingDesign design, double unitPrice) {
        this.design = design;
        this.unitPrice = unitPrice;
    }

    @Override
    public double giveCost() {
        double area = design.computerArea();
        return area * unitPrice;
    }
}