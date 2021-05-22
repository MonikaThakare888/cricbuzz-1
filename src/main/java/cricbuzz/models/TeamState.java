package cricbuzz.models;

public class TeamState {
    private boolean isBatting;
    private Player strikeBatsman;
    private Player nonStrikeBatsman;
    private Player bowler;

    public TeamState(boolean isBatting, Player strikeBatsman, Player nonStrikeBatsman, Player bowler) {
        this.isBatting = isBatting;
        this.strikeBatsman = strikeBatsman;
        this.nonStrikeBatsman = nonStrikeBatsman;
        this.bowler = bowler;
    }

    public boolean isBatting() {
        return isBatting;
    }

    public void setBatting(boolean batting) {
        isBatting = batting;
    }

    public Player getStrikeBatsman() {
        return strikeBatsman;
    }

    public void setStrikeBatsman(Player strikeBatsman) {
        this.strikeBatsman = strikeBatsman;
    }

    public Player getNonStrikeBatsman() {
        return nonStrikeBatsman;
    }

    public void setNonStrikeBatsman(Player nonStrikeBatsman) {
        this.nonStrikeBatsman = nonStrikeBatsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }
}
