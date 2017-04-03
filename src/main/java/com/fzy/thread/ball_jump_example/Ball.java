package com.fzy.thread.ball_jump_example;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 小球移动Entity
 * Created by fuzhongyu on 2017/3/4.
 */
public class Ball {

    private static final int XSIZE=15;
    private static final int YSIZE=15;
    private double x=0;
    private double y=0;
    private double dx=1;
    private double dy=1;

    /**
     * 移动小球到下一个位置，如果装到墙壁小球将调整方向，并重新绘制面板
     * @param bounds
     */
    public void move(Rectangle2D bounds){
        x+=dx;
        y+=dy;
        if(x<bounds.getMinX()){
            x=bounds.getMinX();
            dx=-dx;
        }
        if(x+XSIZE>=bounds.getMaxX()){
            x=bounds.getMaxX()-XSIZE;
            dx=-dx;
        }
        if(y<bounds.getMinY()){
            y=bounds.getMinY();
            dy=-dy;
        }
        if(y+YSIZE>=bounds.getMaxY()){
            y=bounds.getMaxY()-YSIZE;
            dy=-dy;
        }
    }

    /**
     * 获取小球的当前位置
     * @return
     */
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }

}
