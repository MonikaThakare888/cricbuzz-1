package cricbuzz.db.models;

import cricbuzz.models.inning.Over;
import cricbuzz.event.Event;

import java.util.List;
import java.util.stream.Collectors;

public class OverEntity {
    private final List<String> deliveries;

    public OverEntity(List<String> deliveries) {
        this.deliveries = deliveries;
    }

    public Over toOver() {
        return new Over(deliveries.stream().map(Event::from).collect(Collectors.toList()));
    }
}
