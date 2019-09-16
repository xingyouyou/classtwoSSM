package com.bdqn.pojo.test;

import java.util.Map;

/**
 * @ClassName: TestSet
 * @Description: 测试实体（Set参数绑定）
 * @Author: xyf
 * @Date 2019/7/17 11:27
 */
public class TestMap {

    private Map<String, User1> users;

    public Map<String, User1> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User1> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TestMap{" +
                "users=" + users +
                '}';
    }
}
