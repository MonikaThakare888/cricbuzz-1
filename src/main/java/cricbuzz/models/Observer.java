package cricbuzz.models;

import cricbuzz.models.deliveryresult.Event;

public interface Observer {
    public void update(Event event);
}
