package com.fzy.mixed_block.map_know;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map的key值为自定义的对象，判断该对象中的某几个字段来确定是否是同一个key
 *
 * 注：主要是-->重写了hashCode和equals方法
 *
 * Created by fuzhongyu on 2017/5/6.
 */
public class MapObjectKey {

    @Test
    public void test(){
        MyObject object1=new MyObject("1","fzy",23,"hangzhou");
        MyObject object2=new MyObject("2","fzy",23,"shaoxing");

        Map<MyObject,String> map=new HashMap<>();
        map.put(object1,"test1");
        map.put(object2,"test2");
        //输出map
        Iterator iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<MyObject,String> entry= (Map.Entry<MyObject, String>) iterator.next();
            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue()); //输出结果：key:com.fzy.mixed_block.Map.MyObject@194af   value:test2

            //说明object2覆盖了object1，即为相同的key值


        }
    }


}

/**
 * 自定义类，这边我们重新了equels和hashCode方法，认为如果name和age相同则为同一个对象
 */
class MyObject{

    private String id;
    private String name;
    private Integer age;
    private String address;

    public MyObject(){}

    public MyObject(String id,String name,Integer age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    /**
     * Joshua Bloch提出的通用的hashCode生成方法
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyObject other = (MyObject) obj;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        return true;
    }
}
