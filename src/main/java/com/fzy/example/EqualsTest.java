package com.fzy.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fuzhongyu
 * @date 2017/11/29
 */

public class EqualsTest {

   @org.junit.Test
    public void test(){
        IdNameObj obj1=new IdNameObj(2L,new String("2楼"));
        IdNameObj obj2=new IdNameObj(2L,new String("2楼"));

       System.out.println(obj1.equals(obj2));
       Set<IdNameObj> set=new HashSet<>();
       set.add(obj1);
       System.out.println(set.add(obj2));
    }


    /**
     * businessId 和name对象存储类
     */
     class IdNameObj{
        private Long id;
        private String name;

        public IdNameObj(Long id,String name){
            this.id=id;
            this.name=name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof IdNameObj) {
                return EqualsBuilder.reflectionEquals(this, obj, ((IdNameObj) obj).id.toString(), ((IdNameObj) obj).name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this,this.id.toString(),null);
        }
    }
}
