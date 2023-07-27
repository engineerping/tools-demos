package org.jacky.event;
import org.jacky.event.addevent.ButtonFrame;

import javax.swing.*;
import java.awt.*;



public class Test {
    public static void main(String[] args) {
        //EventQueue.invokeLater(Runnable runnable)//这里的runnable是一个时间分派线程
        EventQueue.invokeLater(() -> {
            ButtonFrame frame = new ButtonFrame(); //在时间分派线程中初始化用户界面是推荐的方式
            frame.setTitle("Jacky's Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true); //显示Frame
        });
    }
}
