package cricbuzz.observer;

import org.junit.jupiter.api.Test;

public class EventManagerTest {

    EventManager eventManager = new EventManager();
    Observer observer;

    @Test
    public void test_addSubscriber() {
       //it is giving null list how to test it
        eventManager.addSubscriber(observer);
    }
    // not able to understand how to write test for observer
}
