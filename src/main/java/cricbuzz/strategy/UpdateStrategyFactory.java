package cricbuzz.strategy;

import cricbuzz.models.event.Event;

import static cricbuzz.models.event.EndEvent.INNING_END;
import static cricbuzz.models.event.EndEvent.OVER_END;
import static cricbuzz.models.event.ExtraRunEvent.*;
import static cricbuzz.models.event.OutEvent.*;
import static cricbuzz.models.event.RunEvent.*;

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
        }
        return null;
    }
}
