package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.error.ErrorResource;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int BRIDGE_LENGTH_MIN = 3;
    private static int BRIDGE_LENGTH_MAX = 20;
    private int bridgeLength;
    private Bridge bridge;
    int index = 0;
    private BridgeMaker bridgeMaker;
    private List<String> originalBridge;


    public BridgeGame(int bridgeLength){
        validateBridgeLength(bridgeLength);
        this.bridgeLength =bridgeLength;
        makeOriginalBridge(bridgeLength);
        makeNewBridge();
    }

    public List<String> getOriginalBridge(){
        return originalBridge;
    }

    public void makeNewBridge(){
        bridge = new Bridge();
    }

    public void validateBridgeLength(int bridgeLength){
        if(bridgeLength <BRIDGE_LENGTH_MIN ||bridgeLength>BRIDGE_LENGTH_MAX){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.OUT_OF_RANGE);
        }
    }

    public void makeOriginalBridge(int bridgeLength) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        originalBridge = bridgeMaker.makeBridge(bridgeLength);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveKeyWord) {
        boolean crossResult = addBridgeUnit(moveKeyWord);
        index++;
        return crossResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        makeNewBridge();
        index =0;
    }


    public boolean checkArrive(){
        if(index == bridgeLength){
            return true;
        }
        return false;
    }

    private boolean addBridgeUnit(String moveKeyWord) {
        if(originalBridge.get(index).equals(moveKeyWord)){
            bridge.addBridgeUnit(true, moveKeyWord);
            return true;
        }
        bridge.addBridgeUnit(false, moveKeyWord);
        return false;
    }


    public Bridge getBridge(){
        return bridge;
    }
}
