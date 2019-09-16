package com.bdqn.pojo.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: Admin
 * @Description: 管理员测试实体
 * @Author: xyf
 * @Date 2019/7/17 12:05
 */
@XmlRootElement(name = "admin")
public class Admin {

    private String name;
    private int age;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
