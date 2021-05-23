package cricbuzz.models;

public class OversBowled {
    private int overs;
    private int balls;

    public OversBowled() {
        this.overs = 0;
        this.balls = 0;
    }

    public void increment(){
        this.balls += 1;
        if (balls == 6) {
            this.balls = 0;
            this.overs += 1;
        }
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
