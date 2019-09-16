package com.bdqn.exception;

import com.bdqn.pojo.User;

/**
 * @ClassName: EmBusinessError
 * @Description: 业务错误的枚举（需要实现CommonError中的方法，即CommonError的实现枚举）
 * @Author: xyf
 * @Date 2019/7/16 7:59
 */
public enum EmBusinessError implements CommonError {
    //通用的错误类型10000开头(有些情况用户名没有传入、邮箱为填写都可以使用)
    UNKNOWNERROR(10001,"未知错误"),

    ILLEGAL_ARGS(10002,"不合法参数"),

    //   20000开头为用户信息相关的错误定义
    USER_NOT_EXIST(20001,"用户未找到"),

    ROLE_NOT_FOUND(30001,"用户角色未找到"),

    //关闭枚举设置
    ;

    private int errCode; //错误的代码
    private String errMsg;//错误的描述

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * @Description: 获取错误信息
     * @Param: * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    /**
     * @Description: 获取错误的错误信息
     * @Param: * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    /**
     * @param errMsg
     * @Description: 手动设置的业务信息(定制化)
     * @Param: * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        //return this就是返回当前对象的引用(就是实际调用这个方法的实例化对象)
        return this;
    }

    public static void main(String [] args){
//        Object o=new User();
//        o.toString();
//        CommonError commonError = new EmBusinessError();
//        commonError.setErrMsg()
        BusinessExcpetion businessExcpetion = new BusinessExcpetion(EmBusinessError.UNKNOWNERROR);
        BusinessExcpetion businessExcpetion1 = new BusinessExcpetion(EmBusinessError.USER_NOT_EXIST);
        System.out.println(businessExcpetion.getErrMsg());
        System.out.println(businessExcpetion1.getErrorCode());

    }
}
