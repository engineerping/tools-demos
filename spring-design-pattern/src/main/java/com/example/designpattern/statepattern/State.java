package com.example.designpattern.statepattern;

/**
 * @author gongchengship@163.com
 *
 * 参考: https://time.geekbang.org/column/article/218375
 * 超级马里奥游戏中, 马里奥的状态有三种: 正常状态、无敌状态、死亡状态
 */

public enum State {
    //小马里奥
    SMALL(0),
    //超级马里奥
    SUPER(1),
    //火焰马里奥
    FIRE(2),
    //斗篷马里奥
    CAP(3);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
