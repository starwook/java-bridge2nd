package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgePosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame(3);
    @Test
    void 다리_생성_테스트(){
        for(int i=0;i<bridgeGame.getOriginalBridge().size();i++){
            assertTrue(bridgeGame.getOriginalBridge().get(i)== BridgePosition.MOVE_DOWN.getPositionKey()
            ||bridgeGame.getOriginalBridge().get(i) ==BridgePosition.MOVE_UP.getPositionKey());
        }
    }

    @Test
    void 다리_건너기_테스트(){
        bridgeGame.retry();
        int index =0;
        bridgeGame.move(BridgePosition.MOVE_DOWN.getPositionKey());
        if(bridgeGame.getOriginalBridge().get(index) ==BridgePosition.MOVE_UP.getPositionKey()){
            Assertions.assertThat(bridgeGame.getBridge().getTemporaryBridge().get(index).get(1))
                    .isEqualTo("X");
        }
    }

    @Test
    void 다리_건너기_LIST_중복_테스트(){
        bridgeGame.move(BridgePosition.MOVE_DOWN.getPositionKey());
        bridgeGame.move(BridgePosition.MOVE_UP.getPositionKey());
        bridgeGame.move(BridgePosition.MOVE_UP.getPositionKey());
        Assertions.assertThat(bridgeGame.getBridge().getTemporaryBridge().size())
                .isEqualTo(3);
    }

    @Test
    void 다리_초기화_테스트(){
        bridgeGame.move(BridgePosition.MOVE_DOWN.getPositionKey());
        int originalIndex = bridgeGame.getBridge().getTemporaryBridge().size();
        bridgeGame.retry();
        int newIndex = bridgeGame.getBridge().getTemporaryBridge().size();
        Assertions.assertThat(originalIndex).isEqualTo(newIndex+1);
    }

}