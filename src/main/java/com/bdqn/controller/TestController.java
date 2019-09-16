package com.bdqn.controller;

import com.bdqn.pojo.Role;
import com.bdqn.pojo.User;
import com.bdqn.pojo.test.*;
import com.bdqn.response.CommonReturnType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * ClassName: testController$
 * Description:测试控制器(本质是Servlet分发的前端控制器)
 * Author: anyanglai
 * Date: 2019/8/30
 * Time: 12:09
 */
//@Component
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/test.html")
    public ModelAndView test() {
        logger.info("hello,test!");
        return new ModelAndView("test");
    }

    /**
     * @Description: 基本数据类型的绑定 http://localhost:8080/ssm/test/baseType?userAge=23
     * @param: [age]
     * @return: java.lang.Object
     * @Date: 2019/07/16 8:13
     */
    @PostMapping("/baseType")
    @ResponseBody
    public Object baseType(@RequestParam("age") int age) {
        return CommonReturnType.create("age:" + age);
    }


    /**
     * @Description: 包装类的处理(可以传入空值) http://localhost:8080/ssm/test/baseType2?age=23
     * @param: [age]
     * @return: java.lang.Object
     * @Date: 2019/07/16 8:15
     */
    @PostMapping("/baseType2")
    @ResponseBody
    public Object baseType(Integer age) {
//        return "age:" + age;
        return CommonReturnType.create("age:" + age);
    }

    /**
     * @Description: 数组的绑定 http://localhost:8080/ssm/test/array?game=王者&game=荣耀&game=吃鸡
     * @param: [game]
     * @return: java.lang.Object
     * @Date: 2019/07/16 8:19
     */
    @PostMapping("/array")
    @ResponseBody
    public Object array(@RequestParam("GAME") String[] game) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item :
                game) {
            stringBuilder.append(item).append(" ");
        }
//        return stringBuilder;
        return CommonReturnType.create(stringBuilder);
    }

    /**
     * @Description: http://localhost:8080/ssm/test/object?username=飞飞&gender=1&birthday=2000-05-04
     * @Description: http://localhost:8080/ssm/test/object?id=2
     * @Description: http://localhost:8080/ssm/test/object?user.id=2&role.id=1&user.username=飞飞
     * @Description: http://localhost:8080/ssm/test/object?user.id=2&role.id=1&username=飞机&rolename=经理（ @InitBinder如果使用username等属性，还是可以赋值）
     * @param: [user, role]
     * @return: java.lang.Object
     * @Date: 2019/07/17 8:00
     */
    @RequestMapping("/object")
    @ResponseBody
    public Object object(User user, Role role) {
//        return user.toString();
//        return CommonReturnType.create(user.toString());
        return CommonReturnType.create(user.toString() + "——" + role.toString());
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("role")
    public void initRole(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("role.");
    }

    /**
     * @Description: http://localhost:8080/ms/test/list?users[0].name=王者&users[1].name=荣耀
     * @param: [testEntity]
     * @return: java.lang.Object
     * @Date: 2019/07/17 8:50
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Test test) {
//        return test.toString();
        return CommonReturnType.create(test.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/set?users[0].name=王者&users[1].name=荣耀
     * @param: [testSet]
     * @return: java.lang.Object
     * @Date: 2019/07/17 11:31
     */
    @RequestMapping("/set")
    @ResponseBody
    public Object set(TestSet testSet) {
//        return test.toString();
        return CommonReturnType.create("size:" + testSet.getUsers().size() + "——" + testSet.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/map?users['X'].name=王者&users['X'].age=23
     * http://localhost:8080/ms/test/map?users['X'].name=王者&users['X'].age=23&users['Y'].name=荣耀&users['Y'].age=34
     * @param: [testSet]
     * @return: java.lang.Object
     * @Date: 2019/07/17 11:43
     */
    @RequestMapping("/map")
    @ResponseBody
    public Object map(TestMap testMap) {
        return CommonReturnType.create("size:" + testMap.getUsers().size() + "——" + testMap.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/json
     * {
     * "name":"Jack",
     * "age":12
     * }
     * @param: [user1]
     * @return: java.lang.Object
     * @Date: 2019/07/17 11:54
     */
    @RequestMapping("/json")
    @ResponseBody
    public Object json(@RequestBody User1 user1) {
        return CommonReturnType.create(user1.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/xml
     * <?xml version="1.0" encoding="UTF-8"?>
     * <admin>
     * <name>张三</name>
     * <age>34</age>
     * </admin>
     * @param: [admin]
     * @return: java.lang.Object
     * @Date: 2019/07/17 12:45
     */
    @RequestMapping("/xml")
    @ResponseBody
    public Object xml(@RequestBody Admin admin) {

        return CommonReturnType.create(admin.toString());
    }

    /**
     * @Description:Boolean类型
     * @param: [bool]
     * @return: java.lang.Object
     * @Date: 2019/07/17 13:24
     */
    @RequestMapping("/bool")
    @ResponseBody
    public Object bool(Boolean bool) {
        return CommonReturnType.create(bool.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/date?date1=2018-01-5
     * @param: [date1]
     * @return: java.lang.Object
     * @Date: 2019/07/17 13:34
     */
    @RequestMapping("/date")
    @ResponseBody
    public Object date(Date date1) {
        return CommonReturnType.create(date1.toString());
    }

    /*@InitBinder("date1")
    public void initDate(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }*/

    /**
     * @Description: http://localhost:8080/ms/test/date2?date2=2018-01-5
     * @param: [date2]
     * @return: java.lang.Object
     * @Date: 2019/07/18 7:49
     */
    @RequestMapping("/date2")
    @ResponseBody
    public Object date2(Date date2) {
        return CommonReturnType.create(date2.toString());
    }

    /**
     * @Description: http://localhost:8080/ms/test/book
     * Content-Type:txt/html/json/
     * @param: [request]
     * @return: java.lang.Object
     * @Date: 2019/07/18 8:15
     */
    //    RESTful风格的拓展
    @RequestMapping("/book")
    @ResponseBody
    public Object book(HttpServletRequest request) {

        String contentType = request.getContentType();
        if (contentType == null) {
//            return "book.default";
            return CommonReturnType.create("book.default");
        } else if (contentType.equals("txt")) {
//            return "book.txt";
            return CommonReturnType.create("book.txt");
        } else if (contentType.equals("html")) {
//            return "book.html";
            return CommonReturnType.create("book.html");
        }
        return CommonReturnType.create("book.default");
    }


    //    RESTful风格的拓展
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
    @ResponseBody
    public Object subjectGet(@PathVariable("subjectId") String subjectId) {
        return CommonReturnType.create("this is GET method ,subjectId=" + subjectId);
    }

    //    RESTful风格的拓展
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.POST)
    @ResponseBody
    public Object subjectPost(@PathVariable("subjectId") String subjectId) {
        return CommonReturnType.create("this is POST method ,subjectId=" + subjectId);
    }

    //    RESTful风格的拓展
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object subjectPut(@PathVariable("subjectId") String subjectId) {
        return CommonReturnType.create("this is PUT method ,subjectId=" + subjectId);
    }

    //    RESTful风格的拓展
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object subjectDelete(@PathVariable("subjectId") String subjectId) {
        return CommonReturnType.create("this is DELETE method ,subjectId=" + subjectId);
    }

}
