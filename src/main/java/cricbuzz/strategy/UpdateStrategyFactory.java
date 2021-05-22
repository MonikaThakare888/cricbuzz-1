package cricbuzz.strategy;

import cricbuzz.models.deliveryresult.Event;

import static cricbuzz.models.deliveryresult.OutEvent.*;
import static cricbuzz.models.deliveryresult.RunEvent.*;

public class UpdateStrategyFactory {
    public UpdateStrategy getStrategy(Event event) {
        if (DOT.equals(event) || ONE.equals(event) || TWO.equals(event) || THREE.equals(event) || FOUR.equals(event) || SIX.equals(event)) {
            return new RunEventUpdateStrategy();
        } else if (BOWLED.equals(event) || RUN_OUT.equals(event) || LBW.equals(event) || CATCH_OUT.equals(event)) {
            return new OutEventUpdateStrategy();
        }
        return null;
    }
}
