package com.example.designpattern.statepattern;

/**
 * @author gongchengship@163.com
 */
public class Test {
    public static void main(String[] args) {

        MarioStateMachine marioStateMachine = new MarioStateMachine();
        // 1.1.发生事件,马里奥吃了蘑菇
        marioStateMachine.obtainMushRome();

        // 1.2.导致对象的状态改变
        int score = marioStateMachine.getScore();
        State state = marioStateMachine.getState();

        // 1.3.导致对象的行为发生变化
        System.out.println(marioStateMachine.toString());

        ////
        // 2.1.发生事件:马里奥获得了斗篷
        marioStateMachine.obtainCape();

        // 2.2.导致对象的状态改变
        int scoreAnother = marioStateMachine.getScore();
        State stateAnother = marioStateMachine.getState();

        // 2.3.导致对象的行为发生变化
        System.out.println(marioStateMachine.toString());
    }

}
