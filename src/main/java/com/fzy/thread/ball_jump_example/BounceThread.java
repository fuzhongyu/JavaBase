package com.fzy.thread.ball_jump_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fuzhongyu on 2017/3/4.
 */
public class BounceThread {

    /**
     * -------程序启动入口(多线程)---------
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new BounceFrameRunable();
                frame.setTitle("BounceThread");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BallRunnable implements Runnable{

    private Ball ball;
    private Component component;
    public static final int STEPS=1000;
    public static final int DELAY=5;

    public BallRunnable(Ball aBall,Component aComponent){
        ball=aBall;
        component=aComponent;
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=STEPS;i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


/**
 * 面板
 */
class BounceFrameRunable extends JFrame{

    private BallComponent comp;

    public BounceFrameRunable(){
        comp=new BallComponent();
        add(comp,BorderLayout.CENTER);
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
        Ball b=new Ball();
        comp.add(b);
        Runnable r=new BallRunnable(b,comp);
        Thread t=new Thread(r);
        t.start();
    }
}
