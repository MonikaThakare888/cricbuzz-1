package cricbuzz.models.inning;

import cricbuzz.event.Event;

import java.util.List;

public class Over {
    private final List<Event> deliveries;

    public Over(List<Event> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Event> getDeliveries() {
        return deliveries;
    }

    @Override
    public String toString() {
        return "Over{" +
                "deliveries=" + deliveries +
                '}';
    }
}
