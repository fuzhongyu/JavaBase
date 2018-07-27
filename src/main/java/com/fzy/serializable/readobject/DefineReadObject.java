package com.fzy.serializable.readobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.junit.Test;

/**
 * 自定义序列化readObject方法
 * 该实验的目的是为了查看定义了私有的writeObject和readObject方法为什么会被调用，
 * 结论：通过debug跟踪，发现在ObjectOutputStream和ObjectInputStream类中通过反射调用了这两个方法
 * @author Fucai
 * @date 2018/6/28
 */

public class DefineReadObject {

  @Test
  public void  test(){
    try {
      A a=new A();
      a.setStr("aaa");
      ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("/Users/fuzhongyu/Desktop/logs/a.txt"));
      oos.writeObject(a);
      ObjectInputStream ois=new ObjectInputStream(new FileInputStream("/Users/fuzhongyu/Desktop/logs/a.txt"));
      A a2= (A) ois.readObject();
      System.out.println(a2.getStr());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  class A implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 定义了str为不可序列化
     */
    private transient String str;

    public String getStr() {
      return str;
    }

    public void setStr(String str) {
      this.str = str;
    }

    private void writeObject(ObjectOutputStream s){
      System.out.println("=== my writeObject == ");
    }

    private void readObject(ObjectInputStream s){
      System.out.println("=== my readObject == ");

    }

  }

}
