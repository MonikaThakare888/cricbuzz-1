package cricbuzz.models;

import cricbuzz.models.deliveryresult.Event;
import cricbuzz.strategy.UpdateStrategy;

public interface Observer {
    public void update(UpdateStrategy strategy, Event event);
}
