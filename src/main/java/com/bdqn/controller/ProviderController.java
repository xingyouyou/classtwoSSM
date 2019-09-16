package com.bdqn.controller;

import com.bdqn.pojo.Provider;
import com.bdqn.pojo.Role;
import com.bdqn.pojo.User;
import com.bdqn.service.ProviderService;
import com.bdqn.utils.Page.PageResultBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ProviderController
 * @Description: 供应商管理
 * @Author: xqj
 * @Date: 2019/9/6 15:57
 * @Version v1.0
 */
@Controller
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    //获取用户信息，分页查询
/*    @GetMapping("/userList")
    public String userList(@RequestParam(value = "pageNum", required = false) String pageNum,
                           @RequestParam(value = "queryname", required = false) String queryname,
                           @RequestParam(value = "queryUserRole", required = false) Integer queryUserRole,
                           Model model) {

        if (pageNum == null) {
            pageNum = "1";
        }

        PageHelper.startPage(Integer.parseInt(pageNum), 5, "`p`.creationDate desc");
//        PageResultBean<User> userPageResultBean = new PageResultBean<User>(userService.findUsers());
        PageResultBean<Provider> userPageResultBean = new PageResultBean<User>(providerService.findAllProviders(queryname, queryUserRole));
        List<Provider> providerList = userPageResultBean.getRows();
//        List<Role> roleList = providerService.findRoles();
        model.addAttribute("userList", userList);//分页的实体信息
        model.addAttribute("roleList", roleList);//分页的实体信息
        model.addAttribute("page", userPageResultBean);//分页信息
        model.addAttribute("pageNum", pageNum);//当前页
        return "user/userlist";
    }*/

}
