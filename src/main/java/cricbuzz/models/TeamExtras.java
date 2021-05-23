package cricbuzz.models;

import cricbuzz.models.event.Event;
import cricbuzz.models.event.ExtraRunEvent;
import cricbuzz.strategy.UpdateStrategy;

import java.util.Map;

public class TeamExtras {
    private Map<ExtraRunEvent, Integer> extraRunsReceived;
    private Map<ExtraRunEvent, Integer> extraRunsGiven;

    public TeamExtras(Map<ExtraRunEvent, Integer> extraRunsReceived, Map<ExtraRunEvent, Integer> extraRunsGiven) {
        this.extraRunsReceived = extraRunsReceived;
        this.extraRunsGiven = extraRunsGiven;
    }

    public void updateExtraRunsReceived(ExtraRunEvent extraRunEvent) {
        this.extraRunsReceived.put(extraRunEvent, this.extraRunsReceived.get(extraRunEvent) + 1);
    }

    public void updateExtraRunsGiven(ExtraRunEvent extraRunEvent) {
        this.extraRunsGiven.put(extraRunEvent, this.extraRunsGiven.get(extraRunEvent) + 1);
    }

    public Map<ExtraRunEvent, Integer> getExtraRunsReceived() {
        return extraRunsReceived;
    }

    public void setExtraRunsReceived(Map<ExtraRunEvent, Integer> extraRunsReceived) {
        this.extraRunsReceived = extraRunsReceived;
    }

    public Map<ExtraRunEvent, Integer> getExtraRunsGiven() {
        return extraRunsGiven;
    }

    public void setExtraRunsGiven(Map<ExtraRunEvent, Integer> extraRunsGiven) {
        this.extraRunsGiven = extraRunsGiven;
    }
}
