package com.bdqn.controller;

import com.alibaba.fastjson.annotation.JSONType;
import com.bdqn.exception.BusinessExcpetion;
import com.bdqn.exception.EmBusinessError;
import com.bdqn.pojo.Role;
import com.bdqn.response.CommonReturnType;
import com.bdqn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description: 角色控制器
 * @Author: xcx
 * @Date: 2019/9/9 11:03
 * @Version v1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    /**
     * @Description: 获取用户角色数据
     * @Param:  * @param
     * @return:
     * @Author: xqj
     * @Date:
     */
    @GetMapping("/roleList")
    @ResponseBody
    public CommonReturnType getRolesList() throws BusinessExcpetion {
        List<Role> roleList = null;
        roleList = roleService.findRoles();
        if (roleList.size() == 0) {
            throw new BusinessExcpetion(EmBusinessError.ROLE_NOT_FOUND);
        }
        return CommonReturnType.create(roleList);
    }

}
