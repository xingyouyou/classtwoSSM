package com.bdqn.dao;

import com.bdqn.pojo.Role;

import java.util.List;

/*
 * @Description: 角色数据访问层接口
 * @Author: anyanglai
 * @Date: 2019/8/28 10:59
 * @Param:
 * @return:
 **/
public interface RoleMapper {

    /*
     * @Description: 查询角色数量
     * @Author: anyanglai
     * @Date: 2019/8/28 11:04
     * @Param: []
     * @return: int
     **/
    int selectCount();

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * @Description: 查询到所有角色信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Role>
     * @Date: 2019/07/11 7:59
     */
    List<Role> selectRoles();
}
