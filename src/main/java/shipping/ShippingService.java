package shipping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable pack) {
        packages.add(pack);
    }

    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(p-> p.isBreakable() == breakable && p.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        return packages.stream()
                .collect(Collectors.groupingBy(Transportable::getDestinationCountry,Collectors.reducing(0, e-> 1,Integer::sum)));

        /*.collect(Collectors.groupingBy(Transportable::getDestinationCountry,Collectors.counting()));
        if return type Map<String, Long>*/
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(InternationalPackage.class::isInstance)
                .sorted(Comparator.comparingInt(
                        p->((InternationalPackage)p).getDistance()))
                .toList();
    }
}
