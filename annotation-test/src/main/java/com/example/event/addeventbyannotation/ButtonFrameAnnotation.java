package com.example.event.addeventbyannotation;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Frame是最基础的图形组件
 */
public class ButtonFrameAnnotation extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 618;

    //create buttons，创建3个按钮
    JButton yellowButton;
    JButton blueButton;
    JButton redButton;

    public ButtonFrameAnnotation() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //create buttons，创建3个按钮
        this.yellowButton = new JButton("Yellow");
        this.blueButton = new JButton("Blue");
        this.redButton = new JButton("Red");

        buttonPanel = new JPanel();

        //add buttons to panel，把按钮放到panel中
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //add panel to frame，把panel 放到Frame中
        add(buttonPanel);

        //create button actions, 为按钮添加事件
        /**
        ChangeColorAction changeToYellowAction = new ChangeColorAction(Color.YELLOW);
        ChangeColorAction changeToBlueAction = new ChangeColorAction(Color.BLUE);
        ChangeColorAction changeToRedAction = new ChangeColorAction(Color.RED);
         */


        //associate action with buttons, 给按钮关联具体要做的动作
        //addActionListener是swing组件中AbstractButton中定义的方法，把action 组合到 button中
        /**
        yellowButton.addActionListener(changeToYellowAction);
        blueButton.addActionListener(changeToBlueAction);
        redButton.addActionListener(changeToRedAction);
        */
        //现在用这份方法替代上面六行
        //基本思路:
        //1.给当前类的所有标注了注解的方法，添加
        ActionListenerInstaller.processAnnotation(this);
    }

    @ActionListenerFor(source = "yellowButton")
    public void renderGroundToYellow() {
        buttonPanel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueButton")
    public void renderGroundToBlue() {
        buttonPanel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redButton")
    public void renderGroundToRed() {
        buttonPanel.setBackground(Color.RED);
    }

    /**
     * ChangeColorAction
     */
//    private class ChangeColorAction implements ActionListener {
//        private Color backgroundColor;
//
//        public ChangeColorAction(Color c) {
//            backgroundColor = c;
//        }
//
//        /**
//         * Invoked when an action occurs.
//         *
//         * @param event
//         */
//        @Override
//        public void actionPerformed(ActionEvent event) {
//            //set panel background color
//            buttonPanel.setBackground(backgroundColor);
//        }
//    }

    public static void main(String[] args) throws Exception{
        //EventQueue.invokeLater(Runnable runnable) //这里的runnable是一个时间分派线程
        EventQueue.invokeLater(() -> {
            ButtonFrameAnnotation frame = null; //在时间分派线程中初始化用户界面是推荐的方式
            try {
                frame = new ButtonFrameAnnotation();
                frame.setTitle("Jacky's Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); //显示Frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
