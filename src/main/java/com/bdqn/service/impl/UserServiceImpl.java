package com.bdqn.service.impl;

import com.bdqn.dao.UserMapper;
import com.bdqn.exception.BusinessExcpetion;
import com.bdqn.pojo.User;
import com.bdqn.pojo.viewOBject.UserVO;
import com.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName: UserServiceImpl$
 * Description:用户业务接口实现类
 * Author: anyanglai
 * Date: 2019/8/28
 * Time: 10:57
 */
@Service
//@Service("userService")
//@Scope("singleton")//直接采用注解
//@Scope("protype")//直接采用注解
@Transactional//开启事务注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*
     * @Description: 查询用户数据
     * @Author: anyanglai
     * @Date: 2019/8/28 17:36
     * @Param:
     * @return:
     **/
    public List<User> finderUsers() {
        return userMapper.selectUsers();
    }

    public List<User> findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    public List<User> findUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    public List<User> findUserByUser(User user) {
        return userMapper.selectUserByUser(user);
    }

    public List<User> findUserByRoleName(String roleName) {
        return userMapper.selectUserByRoleName(roleName);
    }

    public List<User> findUserByUserRole(Integer userRole) {
        return userMapper.selectUserByUserRole(userRole);
    }

    public List<User> findUserByUserRoleAndUserNamePaged(Integer userRole, String userName, Integer from, Integer pageSize) {
        return userMapper.selectUserByUserRoleAndUserNamePaged(userRole,userName,from,pageSize);
    }

    public List<User> findUserByUserRoleArray(Integer[] userRoles) {
        return userMapper.selectUserByUserRoleArray(userRoles);
    }

    public List<User> findUserByUserRoleList(List<Integer> userRoleList) {
        return userMapper.selectUserByUserRoleList(userRoleList);
    }

    public List<User> findUserByUserRoleMap(Map<String, Object> userRoleMap) {
        return userMapper.selectUserByUserRoleMap(userRoleMap);
    }

    public List<User> findUserAddressByUserId(Integer id) {
        return userMapper.selectUserAddressByUserId(id);
    }




    /*
     * @Description: 查找用户数量
     * @Author: anyanglai
     * @Date: 2019/8/28 10:56
     * @Param: []
     * @return: int
     **/
    public int findUserCount() {
        return userMapper.selectCount();
    }

//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = {RuntimeException.class,Exception.class})//开启事务注解
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT) //开启事务注解
    public int addUser(User user) {
        int result = 0;
        try {
            if(user == null){
                return 0;//这里是要抛出业务异常
            }else {
                result = userMapper.insertUser(user);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
        return result;

    }

    /*
     * @Description: 修改用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param: [user]
     * @return: int
     **/
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)//开启事务注解
    public Integer modifyUser(User user) {
        return userMapper.updateUserByUser(user);
    }

    public int delUserById(Integer id) {
        int result = 0;
        try {
            if (id != null) {
                result = userMapper.delUser(id);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String userCode, String userPassword) {

        User user = userMapper.selectUserByCodeAndPwd(userCode,userPassword);
        if(user!=null){
            return user;
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findUsers() throws RuntimeException {
        List<User> userList = userMapper.selectUsers();
        return userList;
    }

    /**
     * @param queryUserRole
     * @param queryname
     * @param queryUserRole
     * @Description: 供应商查询
     * @Param: * @param queryname
     * @return:
     * @Author: xqj
     * @Date:
     */
    public List<User> selectUsersByRoleAndName(String queryname, Integer queryUserRole) {
        List<User> userList =userMapper.selectUsersByRoleAndName(queryname,queryUserRole);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findUserByCode(String userCode) {
        if (userCode!=null){
            return userMapper.selectUserByCode(userCode);
        }
                return null;
    }


    /**
     * description: TODO 添加用户（包含用户的上传信息的路径）
     * create time: 2019/9/7 14:10
     * [user]
     * @param user
     * @return boolean
     */
    @Override
    public boolean addUser1(User user) throws BusinessExcpetion {
        boolean flag = false;
        if (userMapper.insertSelective(user)==1){
            flag = true;
        }
        return flag;
    }

    /**
     * description: TODO 根据ID查找到用户信息
     * create time: 2019/9/8 20:35
     * [userId]
     *
     * @param userid
     * @return com.bdqn.pojo.User
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findUserById1(Integer userid){
        return userMapper.selectUserById1(userid);
    }

}
