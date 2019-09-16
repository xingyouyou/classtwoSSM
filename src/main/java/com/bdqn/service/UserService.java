package com.bdqn.service;

import com.bdqn.exception.BusinessExcpetion;
import com.bdqn.pojo.User;
import com.bdqn.pojo.viewOBject.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/*
 * @Description: 用户业务接口
 * @Author: anyanglai
 * @Date: 2019/8/27 17:12
 * @Param: 
 * @return: 
 **/
public interface UserService {




 /*
  * @Description: 查找用户数量
  * @Author: anyanglai
  * @Date: 2019/8/28 10:56
  * @Param: []
  * @return: int
  **/
    int findUserCount();

/*
 * @Description: 查询用户数据
 * @Author: anyanglai
 * @Date: 2019/8/28 17:36
 * @Param:
 * @return:
 **/
    List<User> finderUsers();

    /*
     * @Description: 查询某条用户数据
     * @Author: anyanglai
     * @Date: 2019/8/20 16:29
     * @Param: []
     * @return: int
     **/
    List<User> findUserById(@Param("id") Integer id);

    /*
     * @Description: 通过用户名模糊查询用户
     * @Author: anyanglai
     * @Date: 2019/8/21 13:45
     * @Param: [username]
     * @return: com.bdqn.pojo.User
     **/
    List<User> findUserByUserName(@Param(value = "userName") String userName);

    /*
     * @Description: 通过用户名或用户的code模糊查询用户
     * @Author: anyanglai
     * @Date: 2019/8/21 14:00
     * @Param: [user]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
//    List<User> selectUserByUser(User user);
    List<User> findUserByUser(@Param("u") User user);

    /*
     * @Description: 通过角色名称查询到用户信息
     * @Author: anyanglai
     * @Date: 2019/8/21 14:33
     * @Param: [roleName]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserByRoleName(@Param(value = "roleName") String roleName);

    /*
     * @Description: 通过角色id查询到用户信息（角色信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:05
     * @Param: [userRole]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserByUserRole(@Param(value = "userRole") Integer userRole);

    List<User> findUserByUserRoleAndUserNamePaged(@Param(value = "userRole") Integer userRole,
                                                  @Param(value = "userName") String userName,
                                                  @Param(value = "from") Integer from,
                                                  @Param(value = "pageSize") Integer pageSize);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）数组入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserByUserRoleArray(Integer[] userRoles);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）集合入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserByUserRoleList(List<Integer> userRoleList);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）Map入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserByUserRoleMap(Map<String, Object> userRoleMap);

    /*
     * @Description: 通过id查询到用户地址信息（用户其他信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:08
     * @Param: [id]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUserAddressByUserId(@Param(value = "id") Integer id);

    /*
     * @Description: 添加用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:09
     * @Param: [user]
     * @return: int
     **/

    int addUser(@Param(value = "user") User user);

    /*
     * @Description: 修改用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param: [user]
     * @return: int
     **/
    Integer modifyUser(@Param(value = "user") User user) throws BusinessExcpetion;

    /*
     * @Description: 删除某个id
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param:
     * @return:
     **/
    int delUserById(@Param("id") Integer id)throws BusinessExcpetion;

    /*
     * @Description: 登录
     * @Author: anyanglai
     * @Date: 2019/9/3 15:33
     * @Param: [userCode, userPassword]
     * @return: com.bdqn.pojo.User
     **/
    User login(String userCode, String userPassword);

    /*
     * @Description: 查询所有用户
     * @Author: anyanglai
     * @Date: 2019/9/4 16:43
     * @Param: []
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> findUsers() throws RuntimeException;

    /**
     * @Description: 供应商查询
     * @Param:  * @param queryname
     * @param queryUserRole
     * @return:
     * @Author: xqj
     * @Date:
     */
    List<User> selectUsersByRoleAndName(String queryname, Integer queryUserRole);

    User findUserByCode(String userCode);
    /**
     * description: TODO 添加用户（包含用户的上传信息的路径）
     * create time: 2019/9/7 14:10
     * [user]
     * @return boolean
     */
    boolean addUser1(User user) throws BusinessExcpetion;


    /**
     * description: TODO 根据ID查找到用户信息
     * create time: 2019/9/8 20:35
     * [userId]
     * @return com.bdqn.pojo.User
     */
    User findUserById1(Integer userid);
}
