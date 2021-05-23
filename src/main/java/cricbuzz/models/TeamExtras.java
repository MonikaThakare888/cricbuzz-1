package cricbuzz.models;

import cricbuzz.models.event.ExtraRunEvent;

import java.util.HashMap;
import java.util.Map;

import static cricbuzz.models.event.ExtraRunEvent.*;

public class TeamExtras {
    private Map<ExtraRunEvent, Integer> extraRunsReceived;
    private Map<ExtraRunEvent, Integer> extraRunsGiven;

    public TeamExtras() {
        Map<ExtraRunEvent, Integer> defaultMap = new HashMap<>();
        defaultMap.put(WIDE, 0);
        defaultMap.put(NO_BALL, 0);
        defaultMap.put(BYE, 0);
        defaultMap.put(LEG_BYE, 0);

        this.extraRunsReceived = defaultMap;
        this.extraRunsGiven = defaultMap;
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
