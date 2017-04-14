package com.fzy.proxy.static_proxy;

/**
 * 代理类
 * Created by fuzhongyu on 2017/4/14.
 */
public class ProSubject implements Subject{

    private Subject subject;

    public ProSubject(Subject subject){
        this.subject=subject;
    }

    @Override
    public void getSubject() {

        //添加特有的方法
        getPre();

        //真实方法
        subject.getSubject();

        //添加特有的方法
        getSuf();

    }

    private void getPre(){
        System.out.println("proxy method prefix");
    }

    private void getSuf(){
        System.out.println("proxy method suffix");
    }


    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        ProSubject proSubject=new ProSubject(new RealSubject());
        proSubject.getSubject();
    }

}
