package com.bdqn.exception;

import com.bdqn.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobaExceptionHandler
 * @Description: 全局异常处理
 * @Author: xcx
 * @Date: 2019/9/9 9:49
 * @Version v1.0
 */
@Component
//控制器aop增强
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception e) throws Exception {
        Map<String, Object> responseData = new HashMap<String, Object>();
        if (e instanceof BusinessExcpetion) {//如果异常的类型属于业务异常，则返回业务异常信息（代码+文字）
            BusinessExcpetion businessExcpetion = (BusinessExcpetion) e;
            responseData.put("errCode", businessExcpetion.getErrorCode());
            responseData.put("errMsg", businessExcpetion.getErrMsg());
        } else {//否则返回的是未知异常的信息（代码+文字）
            responseData.put("errCode", EmBusinessError.UNKNOWNERROR.getErrorCode());
            responseData.put("errMsg", EmBusinessError.UNKNOWNERROR.getErrMsg());
        }
        //最后，无论是业务异常还是未知异常都将其存储到格式化后的异常类中（并且都是异常，即处理失败）
        return CommonReturnType.create(responseData, "fail");
    }

}
