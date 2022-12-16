package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeMachine {
    private static String RETRY = "R";
    private static String QUIT = "Q";
    private int totalTry = 1;
    private boolean retry= false;
    private boolean success = false;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeGame bridgeGame;
    
    public void init(){
        outputView.printGameStart();
        makeBridge();
        playGame();
        printTotalResult();
    }

    private void makeBridge() {
        while(true){
            if (getBridgeSize()) continue;
            break;
        }
    }

    private void playGame() {
        while(!bridgeGame.checkArrive()){
            boolean canCross = checkAbleToCross();
            outputView.printMap(bridgeGame.getBridge().getTemporaryBridge());
            if(!canCross){
                if (checkRetry()) break;
            }
            checkArrive();
        }
    }
    private boolean checkAbleToCross() {
        String moveKey;
        moveKey = getMoveCommand();
        return bridgeGame.move(moveKey);
    }

    private String getMoveCommand() {
        String moveKey;
        while(true){
            moveKey = getMoveKey();
            if (moveKey == null) continue;
            break;
        }
        return moveKey;
    }

    private void checkArrive() {
        if(bridgeGame.checkArrive()){
            success = true;
        }
    }

    private boolean checkRetry() {
        getRetryCommand();
        if(!retry){
            return true;
        }
        retry = false;
        return false;
    }

    private void printTotalResult() {
        outputView.printResult();
        outputView.printMap(bridgeGame.getBridge().getTemporaryBridge());
        outputView.printGameSuccess(success);
        outputView.printTotalTry(totalTry);
    }

    private void getRetryCommand() {
        while(true){
            try{
                retryOrQuit();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    private void retryOrQuit() {
        String retryOrQuit = inputView.readGameCommand();
        if(retryOrQuit.equals(RETRY)){
            totalTry++;
            retry = true;
            bridgeGame.retry();
        }
    }

    private boolean getBridgeSize() {
        try{
            int bridgeSize = inputView.readBridgeSize();
            bridgeGame = new BridgeGame(bridgeSize);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private String getMoveKey() {
        try{
            return inputView.readMoving();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
