package cricbuzz.models;

public class OversBowled {
    private int overs;
    private int balls;

    public OversBowled(int overs, int balls) {
        this.overs = overs;
        this.balls = balls;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
