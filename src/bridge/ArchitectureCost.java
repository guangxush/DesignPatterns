package bridge;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public abstract class ArchitectureCost {
    BuildingDesign design;
    double unitPrice;

    public abstract double giveCost();
}
