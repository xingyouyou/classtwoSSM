package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description: 用户控制器
 * @Author: xcx
 * @Date: 2019/9/2 15:37
 * @Version v1.0
 */
@Controller
@RequestMapping("/testuser")
public class UserTestController1 {

    private Logger logger = Logger.getLogger(this.getClass());

    //    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    @GetMapping({"/getUserById", "/getUser"})
    public ModelAndView getUserById(@RequestParam(value = "uId", required = false) Integer id) {
        logger.info("接受到的ID：" + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user"); //找到对应的视图
        modelAndView.addObject("uId", id);//存放模型数据（key/value）
        //省略传过来的参数
        return modelAndView;
    }

    @GetMapping(value = "/getUserById1")
    @ResponseBody
    public Object getUserById1(@RequestParam(value = "uId", required = false) Integer id) {
        logger.info("接受到的ID：" + id);
//        return id;
        return JSON.toJSONString(id);
    }

    /**********************Model**************************/
    @GetMapping(value = "/getUserByName")
    public String getUserByName(@RequestParam(value = "username", required = false) String username,
                                Model model) {
        logger.info("接受到的username：" + username);
        model.addAttribute("userName", username);
//        model.addAttribute(username);
        return "user";
    }

    /**********************Model_Map**************************/
    @GetMapping(value = "/getUserBycode")
    public String getUserBycode(@RequestParam(value = "usercode", required = false) String usercode,
                                ModelMap modelMap) {
        logger.info("接受到的usercode：" + usercode);
        //模拟数据库查询，得到User对象
        User user = new User();
        user.setUserName("派大星");
        user.setGender(1);
        user.setUserCode(usercode);
        user.setCreationDate(new Date());
        modelMap.addAttribute("user", user);
        return "user";
    }

    /**********************Map**************************/
    @GetMapping(value = "/getUserByPhone")
    public String getUserByPhone(@RequestParam(value = "phone", required = false) String phone,
                                 Map<String, Object> map) {
        logger.info("接受到的usercode：" + phone);
        //模拟数据库查询，得到User对象
        User user = new User();
        user.setUserName("派大星");
        user.setGender(1);
        user.setUserCode(phone);
        user.setCreationDate(new Date());
        map.put("user", user);
        return "user";
    }

}
