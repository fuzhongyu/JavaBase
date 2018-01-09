package com.fzy.mixed_block.class_load;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试不同类加载器对instanceof关键字运算的结果影响
 * Created by fuzhongyu on 2017/9/13.
 */
public class ClassLoadTest {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(fileName);
                    if (is==null){
                        return super.loadClass(name);
                    }
                    byte[] bytes=new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0, bytes.length);

                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj=classLoader.loadClass("com.fzy.mixed_block.class_load.LoadTestClass");
        Object obj2=new LoadTestClass();
        System.out.println(obj.getClass());
        //虚拟机中已经存在 com.fzy.mixed_block.class_load.LoadTestClass类了，他是由系统加载器加载，
        // 而这边obj是用自定义加载器加载的，虽然是来自同一个class文件，但却是不同的类，所以输出false
        System.out.println(obj instanceof com.fzy.mixed_block.class_load.LoadTestClass);
        //同为系统类加载器，输出true
        System.out.println(obj2 instanceof com.fzy.mixed_block.class_load.LoadTestClass);

    }
}

class LoadTestClass{
}
