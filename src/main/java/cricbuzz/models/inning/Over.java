package cricbuzz.models.inning;

import cricbuzz.models.deliveryresult.DeliveryResult;

import java.util.List;

public class Over {
    private List<DeliveryResult> deliveries;

    public Over(List<DeliveryResult> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "Over{" +
                "deliveries=" + deliveries +
                '}';
    }
}
