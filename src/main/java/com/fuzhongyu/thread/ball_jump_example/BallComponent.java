package com.fuzhongyu.thread.ball_jump_example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 小球
 * Created by fuzhongyu on 2017/3/4.
 */
public class BallComponent extends JPanel{

    private static final int DEFAULT_WIDTH=450;
    private static final int DEFAULT_HEIGHT=350;

    private List<Ball> balls=new ArrayList<>();

    /**
     * 添加小球
     * @param b
     */
    public void add(Ball b){
        balls.add(b);
    }

    public  void  paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        for (Ball b:balls){
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
