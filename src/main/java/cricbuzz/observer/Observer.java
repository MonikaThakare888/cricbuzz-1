package cricbuzz.observer;

import cricbuzz.models.event.Event;
import cricbuzz.strategy.UpdateStrategy;

public interface Observer {
    void update(UpdateStrategy strategy, Event event);
}
