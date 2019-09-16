package com.bdqn.service.impl;

import com.bdqn.dao.RoleMapper;
import com.bdqn.pojo.Role;
import com.bdqn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色业务接口实现类
 * @Author: xyf
 * @Date 2019/6/27 11:06
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
//    @Qualifier("roleMapper")
    private RoleMapper roleMapper;

    /*public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }*/

    /**
     * @param roleId
     * @Description: 查找到所有角色信息
     * @param: [roleId]
     * @return: java.util.List<com.bdqn.pojo.Role>
     * @Date: 2019/06/27 11:07
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Role findRoleById(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * @Description: 找到所有角色信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Role>
     * @Date: 2019/07/11 7:58
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Role> findRoles() throws RuntimeException {
        return roleMapper.selectRoles();
    }

    @Override
    public int findRoleCount() {
        return 0;
    }

    @Override
    public List<Role> finderRoles() {
        return null;
    }

    @Override
    public List<Role> findRoleById(Integer id) {
        return null;
    }

    @Override
    public List<Role> findRoleByRoleName(String roleName) {
        return null;
    }

    @Override
    public List<Role> findUserByUser(Role role) {
        return null;
    }

    @Override
    public List<Role> findUserByRoleName(String roleName) {
        return null;
    }

    @Override
    public List<Role> findUserByUserRole(Integer userRole) {
        return null;
    }

    @Override
    public List<Role> findUserByUserRoleAndUserNamePaged(Integer userRole, String userName, Integer from, Integer pageSize) {
        return null;
    }

    @Override
    public List<Role> findUserByUserRoleArray(Integer[] userRoles) {
        return null;
    }

    @Override
    public List<Role> findUserByUserRoleList(List<Integer> userRoleList) {
        return null;
    }

    @Override
    public List<Role> findUserByUserRoleMap(Map<String, Object> userRoleMap) {
        return null;
    }

    @Override
    public List<Role> findUserAddressByUserId(Integer id) {
        return null;
    }

    @Override
    public int addUser(Role user) {
        return 0;
    }

    @Override
    public int modifyUser(Role user) {
        return 0;
    }

    @Override
    public int deleteUser(Integer uId) {
        return 0;
    }
}
