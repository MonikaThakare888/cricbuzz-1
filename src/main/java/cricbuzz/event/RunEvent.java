package cricbuzz.event;

public enum RunEvent implements Event {
    DOT, ONE, TWO, THREE, FOUR, SIX;

    public int getRuns(){
        switch (this){
            case ONE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case SIX: return 6;
            default: return 0;
        }
    }
}
