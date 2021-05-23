package cricbuzz.strategy;

import cricbuzz.event.Event;

import static cricbuzz.event.EndEvent.INNING_END;
import static cricbuzz.event.EndEvent.OVER_END;
import static cricbuzz.event.ExtraRunEvent.*;
import static cricbuzz.event.MatchEvent.MATCH_START;
import static cricbuzz.event.OutEvent.*;
import static cricbuzz.event.RunEvent.*;

public class UpdateStrategyFactory {
    public UpdateStrategy getStrategy(Event event) {
        if (DOT.equals(event) || ONE.equals(event) || TWO.equals(event) || THREE.equals(event) || FOUR.equals(event) || SIX.equals(event)) {
            return new RunEventUpdateStrategy();
        } else if (BOWLED.equals(event) || RUN_OUT.equals(event) || LBW.equals(event) || CATCH_OUT.equals(event)) {
            return new OutEventUpdateStrategy();
        } else if (WIDE.equals(event) || NO_BALL.equals(event) || BYE.equals(event) || LEG_BYE.equals(event)) {
            return new ExtraRunEventUpdateStrategy();
        } else if (OVER_END.equals(event) || INNING_END.equals(event)) {
            return new EndEventUpdateStrategy();
        } else if (MATCH_START.equals(event)) {
            return new MatchEventUpdateStrategy();
        }
        return null;
    }
}
