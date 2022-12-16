package bridge.domain;

public enum BridgePosition {

    MOVE_UP("U",1),
    MOVE_DOWN("D",0);

    private String positionKey;
    private int positionNumber;

    BridgePosition(String positionKey, int positionNumber){
        this.positionKey = positionKey;
        this.positionNumber = positionNumber;
    }

    public String getPositionKey(){
        return positionKey;
    }

    public int getPositionNumber(){
        return positionNumber;
    }
}
