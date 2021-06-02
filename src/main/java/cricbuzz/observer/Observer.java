package cricbuzz.observer;

import cricbuzz.event.Event;
import cricbuzz.strategy.UpdateStrategy;

public interface Observer {
    void update(UpdateStrategy strategy, Event event);
}
