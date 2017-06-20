package com.fzy.mixed_block.map_know;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Map;

/**
 * map和object转换工具类
 *
 * Created by fuzhongyu on 2017/5/25.
 */
public class MapObjectTrans {

    /**
     * 将map装成实体类
     * @param map
     * @param beanClass
     * @return
     * @throws ReflectiveOperationException
     */
    public static  Object map2object(Map<String,Object> map,Class<?> beanClass) throws ReflectiveOperationException{
        if(map==null){
            return null;
        }
        Object object=beanClass.newInstance();
        BeanUtils.populate(object,map);
        return object;
    }

    /**
     * 实体类对象转成map
     * @param object
     * @return
     */
    public static Map<?,?> object2map(Object object){
        if(object==null){
            return null;
        }
        return new BeanMap(object);
    }

    /**
     * 测试方法
     */
    @Test
    public void test(){

        class T1{
            private String id;
            private String name;

            public T1(String id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public String toString() {
                return "T1{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        class T2{
            private T1 t1;
            private int age;

            public T2(T1 t1, int age) {
                this.t1 = t1;
                this.age = age;
            }

            @Override
            public String toString() {
                return "T2{" +
                        "t1=" + t1 +
                        ", age=" + age +
                        '}';
            }
        }

        T1 t1=new T1("1","fzy");
        T2 t2=new T2(t1,20);

        System.out.println((Map<String, Object>) object2map(t1));
       Map<String,Object> map1= (Map<String, Object>) object2map(t1);
       Map<String,Object> map2= (Map<String, Object>) object2map(t2);
        System.out.println(map1.get("id")+"--"+map2.get("t1")+"---");
    }

}



