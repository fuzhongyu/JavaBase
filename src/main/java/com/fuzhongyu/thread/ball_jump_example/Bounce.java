package com.fuzhongyu.thread.ball_jump_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fuzhongyu on 2017/3/4.
 */
public class Bounce {

    /**
     * ------程序启动入口（单线程）-----
     * @param args
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * 绘制面板
 */
class BounceFrame extends JFrame{

    private BallComponent comp;
    public static final int STEPS=1000;
    public static final int DELAY=3;

    public BounceFrame(){
        setTitle("Bounce");

        comp=new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel=new JPanel();

        addButton(buttonPanel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(buttonPanel,BorderLayout.SOUTH);
        pack();

    }

    /**
     * 添加按钮
     * @param c
     * @param title
     * @param listener
     */
    public void addButton(Container c, String title, ActionListener listener){
        JButton button=new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 添加小球
     */
    public void addBall(){
        try {
            Ball ball=new Ball();
            comp.add(ball);

            for (int i=1;i<=STEPS;i++){
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
