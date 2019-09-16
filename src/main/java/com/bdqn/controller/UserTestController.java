package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.pojo.User;
import javafx.scene.chart.ValueAxis;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: UserController$
 * Description: 用户控制器
 * Author: anyanglai
 * Date: 2019/9/2
 * Time: 15:37
 */
@Controller
@RequestMapping("/userTest")
public class UserTestController {

    private Logger logger  = Logger.getLogger(this.getClass());

//    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    @GetMapping(value = {"/getUserById","/getUser"})
    public ModelAndView getUserById(@RequestParam(value = "uId",required = false) Integer id){
        logger.info("接收的id:"+id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");//找到对应的视图
        modelAndView.addObject("uId",id);//存放模型数据(键值对)
//        modelAndView.addObject(id);//存放模型数据(值)
        //省略使用传过来的参数
        return modelAndView;
    }

    @GetMapping(value = {"/getUserById1","/getUser1"})
    @ResponseBody
    public Object getUserById1(@RequestParam(value = "uId",required = false) Integer id){
        logger.info("接收的id:"+id);
//        return id;
        return JSON.toJSONString(id);
    }


    /********************************Model*******************************************/

    @GetMapping(value = "/getUserByName")
    public String getUserByName(@RequestParam(value = "username",required = false) String username,
                                Model model){
        logger.info("接收的username:"+username);
        model.addAttribute("username",username);
        return "user";
    }

    /********************************ModelMap*******************************************/

    @GetMapping(value = "/getUserByUserCode")
    public String getUserByUserCode(@RequestParam(value = "userCode",required = false) String userCode,
                                ModelMap modelMap){
        logger.info("接收的userCode:"+userCode);
        //模拟数据库查询得到user对象
        User user = new User();
        user.setUserName("科比");
        user.setGender(1);
        user.setUserCode(userCode);
        user.setCreationDate(new Date());

        modelMap.addAttribute("user",user);
        return "user";
    }

    /********************************Map*******************************************/

    @GetMapping(value = "/getUserByPhone")
    public String getUserByPhone(@RequestParam(value = "phone",required = false) String phone,
                                    Map<String,Object> map){
        logger.info("接收的userCode:"+phone);
        //模拟数据库查询得到user对象
        User user = new User();
        user.setUserName("科比");
        user.setGender(1);
        user.setPhone(phone);
        user.setCreationDate(new Date());

        map.put("user",user);
        return "user";
    }


}
