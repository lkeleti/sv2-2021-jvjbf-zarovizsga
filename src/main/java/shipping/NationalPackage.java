package shipping;

public class NationalPackage implements Transportable {
    private int weight;
    private boolean breakable;

    private final int DEFAULT_PRICE = 1000;
    private final int MULTIPLIER_BREAKABLE = 2;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        return breakable ? DEFAULT_PRICE*MULTIPLIER_BREAKABLE: DEFAULT_PRICE;
    }
}
