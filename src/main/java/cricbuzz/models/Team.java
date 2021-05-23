package cricbuzz.models;

import cricbuzz.models.event.Event;
import cricbuzz.observer.Observer;
import cricbuzz.strategy.UpdateStrategy;

import java.util.List;

public class Team implements Observer {
    private String name;
    private List<Player> players;
    private TeamExtras teamExtras;
    private boolean isBatting;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.teamExtras = new TeamExtras();
        this.isBatting = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public TeamExtras getTeamExtras() {
        return teamExtras;
    }

    public void setTeamExtras(TeamExtras teamExtras) {
        this.teamExtras = teamExtras;
    }

    public boolean isBatting() {
        return isBatting;
    }

    public void setBatting(boolean batting) {
        isBatting = batting;
    }

    @Override
    public void update(UpdateStrategy strategy, Event event) {
        strategy.updateTeam(this, event);
    }
}
