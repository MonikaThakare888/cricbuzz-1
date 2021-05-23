package cricbuzz.strategy;

import cricbuzz.models.*;
import cricbuzz.models.deliveryresult.Event;
import cricbuzz.models.deliveryresult.OutEvent;

public class OutEventUpdateStrategy implements UpdateStrategy {

    @Override
    public void updateBattingStats(BattingStats battingStats, Event event) {
        /*
        * set strike batsman out-type
        * set isStrikeBatsman field as false
        * set isStrikeBatsman to true for the correct batsman
        * */
        if(battingStats.isStrikeBatsman()){
            battingStats.setOutEvent((OutEvent) event);
            battingStats.setIsStrikeBatsman(false);
        }
    }

    @Override
    public void updateBowlingStats(BowlingStats bowlingStats, Event event) {

    }

    @Override
    public void updateTeamExtras(TeamExtras teamExtras, Event event) {

    }

    @Override
    public void updateTeam(Team team, Event event) {

    }
}
