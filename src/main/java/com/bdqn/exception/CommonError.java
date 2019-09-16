package com.bdqn.exception;

/**
 * @Description:
 * @Author: xqj
 * @Date: 2019/9/9 8:43
 * @Version v1.0
 */
public interface CommonError {
    /**
     * @Description: 获取错误信息
     * @Param:  * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    int getErrorCode();

    /**
     * @Description: 获取错误的错误信息
     * @Param:  * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    String getErrMsg();

    /**
     * @Description: 手动设置的业务信息(定制化)
     * @Param:  * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    CommonError setErrMsg(String errMsg);

}
