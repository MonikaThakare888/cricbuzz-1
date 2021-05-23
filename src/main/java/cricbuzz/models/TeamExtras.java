package cricbuzz.models;

import cricbuzz.models.event.Event;
import cricbuzz.models.event.ExtraRunEvent;
import cricbuzz.strategy.UpdateStrategy;

import java.util.Map;

public class TeamExtras implements Observer{
    private Map<ExtraRunEvent, Integer> extraRunsReceived;
    private Map<ExtraRunEvent, Integer> extraRunsGiven;

    public TeamExtras(Map<ExtraRunEvent, Integer> extraRunsReceived, Map<ExtraRunEvent, Integer> extraRunsGiven) {
        this.extraRunsReceived = extraRunsReceived;
        this.extraRunsGiven = extraRunsGiven;
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

    @Override
    public void update(UpdateStrategy strategy, Event event) {
        strategy.updateTeamExtras(this, event);
    }
}
