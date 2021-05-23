package cricbuzz.observer;

import cricbuzz.event.Event;
import cricbuzz.strategy.UpdateStrategy;
import cricbuzz.strategy.UpdateStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Observer> subscribers = new ArrayList<>();

    public EventManager() {
    }

    public void addSubscriber(Observer observer) {
        this.subscribers.add(observer);
    }

    public void addSubscriber(List<Observer> observers) {
        this.subscribers.addAll(observers);
    }

    public void notifySubscribers(Event event){
        UpdateStrategyFactory factory = new UpdateStrategyFactory();
        UpdateStrategy strategy = factory.getStrategy(event);
        subscribers.forEach(subscriber ->  subscriber.update(strategy, event));
    }
}
