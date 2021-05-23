package cricbuzz.models;

import cricbuzz.models.event.Event;
import cricbuzz.observer.Observer;
import cricbuzz.strategy.UpdateStrategy;

public class BowlingStats implements Observer {
    private OversBowled oversBowled;
    private int runs;
    private int wickets;
    private int wides;
    private int noBalls;
    private boolean isBowling;

    public void incrementOversBowled() {
        this.oversBowled.increment();
    }

    public void incrementRuns(int runs) {
        this.runs += runs;
    }

    public void incrementWickets() {
        this.wickets += 1;
    }

    public void incrementNoBalls() {
        this.noBalls += 1;
    }

    public void incrementWides() {
        this.wides += 1;
    }

    public boolean isBowling() {
        return isBowling;
    }

    public void setBowling(boolean bowling) {
        isBowling = bowling;
    }

    public OversBowled getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(OversBowled oversBowled) {
        this.oversBowled = oversBowled;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getWides() {
        return wides;
    }

    public void setWides(int wides) {
        this.wides = wides;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public void setNoBalls(int noBalls) {
        this.noBalls = noBalls;
    }

    @Override
    public void update(UpdateStrategy strategy, Event event) {
        strategy.updateBowlingStats(this, event);
    }
}
