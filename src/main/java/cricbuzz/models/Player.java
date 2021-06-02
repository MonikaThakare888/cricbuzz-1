package cricbuzz.models;

public class Player {
    private final int id;
    private final String name;
    private BattingStats battingStats;
    private BowlingStats bowlingStats;
    private final int battingOrder;
    private final int bowlingOrder;

    public Player(int id, String name, int battingOrder, int bowlingOrder) {
        this.id = id;
        this.name = name;
        this.battingOrder = battingOrder;
        this.bowlingOrder = bowlingOrder;
        this.battingStats = new BattingStats();
        this.bowlingStats = new BowlingStats();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BattingStats getBattingStats() {
        return battingStats;
    }

    public void setBattingStats(BattingStats battingStats) {
        this.battingStats = battingStats;
    }

    public BowlingStats getBowlingStats() {
        return bowlingStats;
    }

    public void setBowlingStats(BowlingStats bowlingStats) {
        this.bowlingStats = bowlingStats;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public int getBowlingOrder() {
        return bowlingOrder;
    }
}
