package cricbuzz.models;

import cricbuzz.models.event.Event;
import cricbuzz.models.event.OutEvent;
import cricbuzz.models.event.RunEvent;
import cricbuzz.strategy.UpdateStrategy;

import java.util.Map;

public class BattingStats implements Observer {
    private int runs;
    private int balls;
    private Map<RunEvent, Integer> runsDistribution;
    private OutEvent outEvent;
    private boolean isStrikeBatsman;
    private boolean isNonStrikeBatsman;

    public void incrementRuns(int runs) {
        this.runs += runs;
    }

    public void incrementBalls() {
        this.balls += 1;
    }

    public OutEvent getOutEvent() {
        return outEvent;
    }

    public void incrementRunEvent(RunEvent runEvent) {
        this.runsDistribution.put(runEvent, this.runsDistribution.get(runEvent) + 1 );
    }

    public void setOutEvent(OutEvent outEvent) {
        this.outEvent = outEvent;
    }

    public boolean isStrikeBatsman() {
        return isStrikeBatsman;
    }

    public void setIsStrikeBatsman(boolean isStrikeBatsman) {
        this.isStrikeBatsman = isStrikeBatsman;
    }

    public boolean isNonStrikeBatsman() {
        return isNonStrikeBatsman;
    }

    public void setIsNonStrikeBatsman(boolean isNonStrikeBatsman) {
        this.isNonStrikeBatsman = isNonStrikeBatsman;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public Map<RunEvent, Integer> getRunsDistribution() {
        return runsDistribution;
    }

    public void setRunsDistribution(Map<RunEvent, Integer> runsDistribution) {
        this.runsDistribution = runsDistribution;
    }

    public OutEvent getOutType() {
        return outEvent;
    }

    public void setOutType(OutEvent outEvent) {
        this.outEvent = outEvent;
    }

    @Override
    public void update(UpdateStrategy strategy, Event event) {
        strategy.updateBattingStats(this, event);
    }
}
