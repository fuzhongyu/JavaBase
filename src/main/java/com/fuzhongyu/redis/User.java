package com.fuzhongyu.redis;

import java.io.Serializable;
import java.util.UUID;

/**
 * 用户测试类
 * Created by fuzhongyu on 2017/3/19.
 */
public class User implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;
    private String name;   //用户名字
    private Integer gender;  //用户性别 0-男，1-女
    private Integer age;  //用户年龄

    /**
     * 无参构造器
     */
    public User(){}

    /**
     * 有参构造器
     * @param name
     * @param gender
     * @param age
     */
    public User(String name,Integer gender,Integer age){
        this.id=buildUUId();
        this.name=name;
        this.gender=gender;
        this.age=age;
    }

    /**
     * 生成id
     * @return
     */
    public String buildUUId(){
        return String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
