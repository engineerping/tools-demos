package com.example.designpattern.state_design_pattern;

/**
 * @author gongchengship@163.com
 *
 * 超级马里奥游戏的 状态机
 */
public class MarioStateMachine {
    // 玩家马里奥得分
    private int score;
    // 玩家马里奥当前状态
    private State currentState;

    /**
     * 马里奥出生
     */
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRome() {
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score += 200;
        }
    }

    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    public void meedMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }

        if (currentState.equals(State.CAP)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getState() {
        return this.currentState;
    }

    public String toString() {
        return "当前状态：" + currentState + "，得分：" + score;
    }

}
