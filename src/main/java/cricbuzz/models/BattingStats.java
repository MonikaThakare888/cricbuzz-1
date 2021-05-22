package cricbuzz.models;

import cricbuzz.models.deliveryresult.OutType;
import cricbuzz.models.deliveryresult.RunType;

import java.util.Map;

public class BattingStats {
    private int runs;
    private int balls;
    private Map<RunType, Integer> runsDistribution;
    private OutType outType;

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

    public Map<RunType, Integer> getRunsDistribution() {
        return runsDistribution;
    }

    public void setRunsDistribution(Map<RunType, Integer> runsDistribution) {
        this.runsDistribution = runsDistribution;
    }

    public OutType getOutType() {
        return outType;
    }

    public void setOutType(OutType outType) {
        this.outType = outType;
    }
}
