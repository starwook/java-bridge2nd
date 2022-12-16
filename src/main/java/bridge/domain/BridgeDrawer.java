package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeDrawer {
    private List<List<String>> bridgeToDraw;
    private List<String> bridgeUp  = new ArrayList<>();
    private List<String> bridgeDown = new ArrayList<>();
    private static int position =0;
    private static int result = 1;
    private static String NOTHING =" ";
    private static String BRIDGE_LEFT ="[ ";
    private static String BRIDGE_MID =" | ";
    private static String BRIDGE_RIGHT =" ]";
    public BridgeDrawer(List<List<String>> temporaryBridge){
        bridgeToDraw = temporaryBridge;
    }
    public void draw(){
        makeEachBridge();
        drawEachBridge(bridgeUp);
        drawEachBridge(bridgeDown);
    }

    public void drawEachBridge(List<String> eachBridge){
        System.out.print(BRIDGE_LEFT);
        for(int i=0;i<eachBridge.size();i++){
            System.out.print(eachBridge.get(i));
            if(i <eachBridge.size()-1){
                System.out.print(BRIDGE_MID);
            }
        }
        System.out.println(BRIDGE_RIGHT);
    }
    public void makeEachBridge(){
        for(int i=0;i<bridgeToDraw.size();i++){
            makeAsPosition(i);
        }
    }

    private void makeAsPosition(int i) {
        if(bridgeToDraw.get(i).get(position).equals(BridgePosition.MOVE_DOWN.getPositionKey())){
            bridgeDown.add(bridgeToDraw.get(i).get(result));
            bridgeUp.add(NOTHING);
            return;
        }
        bridgeUp.add(bridgeToDraw.get(i).get(result));
        bridgeDown.add(NOTHING);
    }

}
