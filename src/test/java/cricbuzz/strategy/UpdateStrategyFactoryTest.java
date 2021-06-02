package cricbuzz.strategy;

import org.junit.jupiter.api.Test;

import static cricbuzz.event.EndEvent.INNING_END;
import static cricbuzz.event.EndEvent.OVER_END;
import static cricbuzz.event.ExtraRunEvent.*;
import static cricbuzz.event.ExtraRunEvent.LEG_BYE;
import static cricbuzz.event.MatchEvent.MATCH_START;
import static cricbuzz.event.OutEvent.*;
import static cricbuzz.event.OutEvent.CATCH_OUT;
import static cricbuzz.event.RunEvent.*;
import static cricbuzz.event.RunEvent.SIX;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateStrategyFactoryTest {
    UpdateStrategyFactory updateStrategyFactory = new UpdateStrategyFactory();

   @Test
   void should_return_RunEventUpdateStrategy_when_event_is_runEvent() {
       UpdateStrategy updateStrategy = updateStrategyFactory.getStrategy(DOT);
       UpdateStrategy updateStrategy1 = updateStrategyFactory.getStrategy(ONE);
       UpdateStrategy updateStrategy2 = updateStrategyFactory.getStrategy(TWO);
       UpdateStrategy updateStrategy3 = updateStrategyFactory.getStrategy(THREE);
       UpdateStrategy updateStrategy4 = updateStrategyFactory.getStrategy(FOUR);
       UpdateStrategy updateStrategy5 = updateStrategyFactory.getStrategy(SIX);

       assertAll(
               () -> assertTrue(updateStrategy instanceof RunEventUpdateStrategy),
               () -> assertTrue(updateStrategy1 instanceof RunEventUpdateStrategy),
               () -> assertTrue(updateStrategy2 instanceof RunEventUpdateStrategy),
               () -> assertTrue(updateStrategy3 instanceof RunEventUpdateStrategy),
               () -> assertTrue(updateStrategy4 instanceof RunEventUpdateStrategy),
               () -> assertTrue(updateStrategy5 instanceof RunEventUpdateStrategy)
       );
   }
    @Test
    void should_return_OutEventUpdateStrategy_when_event_is_outEvent() {
        UpdateStrategy updateStrategy = updateStrategyFactory.getStrategy(BOWLED);
        UpdateStrategy updateStrategy1 = updateStrategyFactory.getStrategy(RUN_OUT);
        UpdateStrategy updateStrategy2 = updateStrategyFactory.getStrategy(LBW);
        UpdateStrategy updateStrategy3 = updateStrategyFactory.getStrategy(CATCH_OUT);
        assertAll(
                () -> assertTrue(updateStrategy instanceof OutEventUpdateStrategy),
                () -> assertTrue(updateStrategy1 instanceof OutEventUpdateStrategy),
                () -> assertTrue(updateStrategy2 instanceof OutEventUpdateStrategy),
                () -> assertTrue(updateStrategy3 instanceof OutEventUpdateStrategy)
        );
    }
    @Test
    void should_return_ExtraRunEventUpdateStrategy_when_event_is_extraRunEvent() {
        UpdateStrategy updateStrategy = updateStrategyFactory.getStrategy(WIDE);
        UpdateStrategy updateStrategy1 = updateStrategyFactory.getStrategy(NO_BALL);
        UpdateStrategy updateStrategy2 = updateStrategyFactory.getStrategy(BYE);
        UpdateStrategy updateStrategy3 = updateStrategyFactory.getStrategy(LEG_BYE);
        assertAll(
                () -> assertTrue(updateStrategy instanceof ExtraRunEventUpdateStrategy),
                () -> assertTrue(updateStrategy1 instanceof ExtraRunEventUpdateStrategy),
                () -> assertTrue(updateStrategy2 instanceof ExtraRunEventUpdateStrategy),
                () -> assertTrue(updateStrategy3 instanceof ExtraRunEventUpdateStrategy)
                );
    }
    @Test
    void should_return_EndEventUpdateStrategy_when_event_is_endEvent() {
        UpdateStrategy updateStrategy = updateStrategyFactory.getStrategy(OVER_END);
        UpdateStrategy updateStrategy1 = updateStrategyFactory.getStrategy(INNING_END);

        assertAll(
                () -> assertTrue(updateStrategy instanceof EndEventUpdateStrategy),
                () -> assertTrue(updateStrategy1 instanceof EndEventUpdateStrategy)
        );
    }
    @Test
    void should_return_MatchEventUpdateStrategy_when_event_is_MATCH_START() {
        UpdateStrategy updateStrategy = updateStrategyFactory.getStrategy(MATCH_START);
        assertTrue(updateStrategy instanceof MatchEventUpdateStrategy);
    }
}
