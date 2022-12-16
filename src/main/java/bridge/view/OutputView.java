package bridge.view;

import bridge.domain.BridgeDrawer;
import bridge.domain.BridgePosition;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static String GAME_START ="다리 건너기 게임을 시작합니다.\n";
    private static String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static String INPUT_BRIDGE_POSITION = "이동할 칸을 선택해주세요. (위: ";
    private static String I_B_P_MID = ", 아래: ";
    private static String END = ")";
    private static String RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: ";
    private static String RG_MID = ", 종료:";
    private static String GAME_RESULT = "최종 게임 결과";
    private static String GAME_SUCCESS ="게임 성공 여부: ";
    private static String TOTAL_TRY ="총 시도한 횟수: ";
    private static String IF_SUCCESS ="성공";
    private static String IF_FAIL ="실패";

    public void printGameStart(){
        System.out.println(GAME_START);
    }
    public void printInputBridgeLength(){
        System.out.println(INPUT_BRIDGE_LENGTH);
    }
    public void printInputBridgePosition(){
        System.out.println(INPUT_BRIDGE_POSITION+ BridgePosition.MOVE_UP.getPositionKey()
        +I_B_P_MID+BridgePosition.MOVE_DOWN.getPositionKey()+END);
    }
    public void printRetryGame(String retry,String stop){
        System.out.println(RETRY_GAME+retry+RG_MID+stop+END);
    }
    public void printResult() {
        System.out.println(GAME_RESULT);
    }
    public void printGameSuccess(boolean success){
        System.out.print(GAME_SUCCESS);
        if(success){
            System.out.println(IF_SUCCESS);
        }
        if(!success){
            System.out.println(IF_FAIL);
        }
    }
    public void printMap(List<List<String>> temporaryBridge) {
        BridgeDrawer bridgeDrawer = new BridgeDrawer(temporaryBridge);
        bridgeDrawer.draw();
    }
    public void printTotalTry(int totalTry){
        System.out.println(TOTAL_TRY+totalTry);
    }

    public void printError(String errorMessage){
        System.out.println(errorMessage);
    }

}
