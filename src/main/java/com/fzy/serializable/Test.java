package com.fzy.serializable;

import java.util.Arrays;

/**
 * 序列化测试类
 * Created by fuzhongyu on 2017/3/20.
 */
public class Test {

    @org.junit.Test
    public void test(){
        UserSerializable user=new UserSerializable("fzy",0,25);

        //序列化
        byte[] bytes=SerializableUtils.serialize(user);
        System.out.println(Arrays.toString(bytes));

        //反序列化
        UserSerializable u= (UserSerializable) SerializableUtils.unserialize(bytes);
        System.out.println(u.getName());
    }
}
