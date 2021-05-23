package cricbuzz.event;

public interface Event {
    static Event from(String outType) {
        switch (outType) {
            case "WD": return ExtraRunEvent.WIDE;
            case "NB": return ExtraRunEvent.NO_BALL;
            case "B": return ExtraRunEvent.BYE;
            case "LB": return ExtraRunEvent.LEG_BYE;
            case "CO": return OutEvent.CATCH_OUT;
            case "RO": return OutEvent.RUN_OUT;
            case "LBW": return OutEvent.LBW;
            case "W": return OutEvent.BOWLED;
            case "0": return RunEvent.DOT;
            case "1": return RunEvent.ONE;
            case "2": return RunEvent.TWO;
            case "3": return RunEvent.THREE;
            case "4": return RunEvent.FOUR;
            case "6": return RunEvent.SIX;
            default: return null;
        }
    }
}
