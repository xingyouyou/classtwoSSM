package com.bdqn.exception;

/**
 * @ClassName BusinessExcpetion
 * @Description: 业务异常类
 * @Author: xcx
 * @Date: 2019/9/9 8:50
 * @Version v1.0
 */
public class BusinessExcpetion  extends Exception implements CommonError{


    //这里的CommonError本质是CommonError的实现类EmBusinessError
    private CommonError commonError;

    //**构造业务异常（注入）
    public BusinessExcpetion(CommonError commonError){
        super();
        this.commonError = commonError;
    }
    //**构造业务异常类（需要自定义的错误代码和信息）
    public BusinessExcpetion( CommonError commonError,String errMsg){
        this(commonError);
        this.commonError.setErrMsg(errMsg);
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
        return commonError.getErrorCode();
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
        return commonError.getErrMsg();
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
        this.commonError.setErrMsg(errMsg);
        return commonError;
    }
}
