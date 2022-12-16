package bridge.view;

import bridge.domain.BridgePosition;
import bridge.error.ErrorResource;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();
    private static String RETRY = "R";
    private static String QUIT = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputBridgeLength();
        String bridgeSize = Console.readLine();
        try{
            Integer.parseInt(bridgeSize);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.NOT_NUMBER);
        }
        return Integer.parseInt(bridgeSize);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputBridgePosition();
        String bridgePosition = Console.readLine();
        if(bridgePosition.equals(BridgePosition.MOVE_DOWN.getPositionKey())
        || bridgePosition.equals(BridgePosition.MOVE_UP.getPositionKey())){
            return bridgePosition;
        }
        throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.WRONG_MOVE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetryGame(RETRY,QUIT);
        String retry = Console.readLine();
        if(!retry.equals(RETRY) && !retry.equals(QUIT)){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.WRONG_RETRY);
        }
        return retry;
    }
}
