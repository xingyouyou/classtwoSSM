package com.bdqn.pojo.test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName: TestSet
 * @Description: 测试实体（Set参数绑定）
 * @Author: xyf
 * @Date 2019/7/17 11:27
 */
public class TestSet {

    private Set<User1> users;

    public TestSet() {
        users = new LinkedHashSet<User1>();
        users.add(new User1());
        users.add(new User1());
    }

    public Set<User1> getUsers() {
        return users;
    }

    public void setUsers(Set<User1> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TestSet{" +
                "users=" + users +
                '}';
    }
}
