package shipping;

public class InternationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    private final int DEFAULT_PRICE = 1200;
    private final int MULTIPLIER_BREAKABLE = 2;
    private final int DEFAULT_PRICE_PER_DISTANCE = 10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
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
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int calculateShippingPrice() {
        return (breakable ? DEFAULT_PRICE * MULTIPLIER_BREAKABLE : DEFAULT_PRICE) + distance * DEFAULT_PRICE_PER_DISTANCE;
    }
}
