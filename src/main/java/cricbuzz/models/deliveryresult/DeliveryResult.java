package cricbuzz.models.deliveryresult;

public interface DeliveryResult {
    static DeliveryResult from(String outType) {
        switch (outType) {
            case "WD": return ExtraRunType.WIDE;
            case "NB": return ExtraRunType.NO_BALL;
            case "B": return ExtraRunType.BYE;
            case "LB": return ExtraRunType.LEG_BYE;
            case "CO": return OutType.CATCH_OUT;
            case "RO": return OutType.RUN_OUT;
            case "LBW": return OutType.LBW;
            case "W": return OutType.BOWLED;
            case "0": return RunType.DOT;
            case "1": return RunType.ONE;
            case "2": return RunType.TWO;
            case "3": return RunType.THREE;
            case "4": return RunType.FOUR;
            case "6": return RunType.SIX;
            default: return null;
        }
    }
}
