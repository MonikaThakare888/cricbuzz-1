package cricbuzz.models;

import cricbuzz.models.deliveryresult.Event;
import cricbuzz.models.deliveryresult.OutEvent;
import cricbuzz.models.deliveryresult.RunEvent;

import java.util.Map;

public class BattingStats {
    private int runs;
    private int balls;
    private Map<RunEvent, Integer> runsDistribution;
    private OutEvent outEvent;

    public void update(Event event){

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
}
