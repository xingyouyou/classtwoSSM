package com.bdqn.pojo.test;
/**
 * @ClassName: HelloSpring
 * @Description:  HelloSpring实体类
 * @Author: xyf
 * @Date 2019/6/25 10:28
 */
public class HelloSpring {
    // 定义who属性，该属性的值将通过Spring框架进行设置
    private String who = null;

   /* public HelloSpring(String who) {
        this.who = who;
    }*/

    public String getWho() {
        return who;
    }

//    使用设值注入的方法
    public void setWho(String who) {
        this.who = who;
    }

    /**
     * @Description: 打印出hello+内容
     * @param: []
     * @return: void
     * @Date: 2019/06/25 10:30
     */
    public void print() {
        System.out.println("Hello," + this.getWho() + "!");
    }
}
