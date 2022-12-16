package bridge.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bridge {
    private static String CAN_CROSS = "O";
    private static String CANT_CROSS = "X";
    private List<List<String>> temporaryBridge = new ArrayList<>();
    public Bridge(){

    }
    public void addBridgeUnit(boolean crossable,String positionKey){
        List<String> bridgeUnit = new ArrayList<>();
        bridgeUnit.add(positionKey);
        if(crossable){
            bridgeUnit.add(CAN_CROSS);
        }
        if(!crossable){
            bridgeUnit.add(CANT_CROSS);
        }
        temporaryBridge.add(bridgeUnit);
    }

    public List<List<String>> getTemporaryBridge(){
        return temporaryBridge;
    }


}
