package com.bdqn.dao;

import com.bdqn.pojo.User;
import com.bdqn.pojo.viewOBject.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * @Description: 用户数据访问层接口
 * @Author: anyanglai
 * @Date: 2019/8/28 10:59
 * @Param:
 * @return:
 **/
public interface UserMapper {

    /*
     * @Description: 查询用户数量
     * @Author: anyanglai
     * @Date: 2019/8/28 11:04
     * @Param: []
     * @return: int
     **/
    int selectCount();

    /*
     * @Description: 查询用户数据
     * @Author: anyanglai
     * @Date: 2019/8/20 16:29
     * @Param: []
     * @return: int
     **/
     List<User> selectUsers();

    /*
     * @Description: 查询某条用户数据
     * @Author: anyanglai
     * @Date: 2019/8/20 16:29
     * @Param: []
     * @return: int
     **/
    List<User> selectUserById(@Param("id") Integer id);

    /*
     * @Description: 通过用户名模糊查询用户
     * @Author: anyanglai
     * @Date: 2019/8/21 13:45
     * @Param: [username]
     * @return: com.bdqn.pojo.User
     **/
    List<User> selectUserByUserName(@Param(value = "userName") String userName);

    /*
     * @Description: 通过用户名或用户的code模糊查询用户
     * @Author: anyanglai
     * @Date: 2019/8/21 14:00
     * @Param: [user]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
//    List<User> selectUserByUser(User user);
    List<User> selectUserByUser(@Param("u") User user);

    /*
     * @Description: 通过角色名称查询到用户信息
     * @Author: anyanglai
     * @Date: 2019/8/21 14:33
     * @Param: [roleName]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> selectUserByRoleName(@Param(value = "roleName") String roleName);

    /*
     * @Description: 通过角色id查询到用户信息（角色信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:05
     * @Param: [userRole]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> selectUserByUserRole(@Param(value = "userRole") Integer userRole);

    List<User> selectUserByUserRoleAndUserNamePaged(@Param(value = "userRole") Integer userRole,
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
    List<User> selectUserByUserRoleArray(Integer[] userRoles);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）集合入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> selectUserByUserRoleList(List<Integer> userRoleList);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）Map入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> selectUserByUserRoleMap(Map<String, Object> userRoleMap);

    /*
     * @Description: 通过id查询到用户地址信息（用户其他信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:08
     * @Param: [id]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<User> selectUserAddressByUserId(@Param(value = "id") Integer id);

    /*
     * @Description: 添加用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:09
     * @Param: [user]
     * @return: int
     **/
//    int insertUser(User user);
    int insertUser(@Param(value = "user") User user);

    /*
     * @Description: 修改用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param: [user]
     * @return: int
     **/
    Integer updateUser(@Param(value = "user") User user);

    /*
     * @Description: 删除用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param:
     * @return:
     **/
    int delUser(@Param("uId") Integer id);


    User selectUserByCodeAndPwd(@Param("userCode") String userCode, @Param("pwd") String pwd);


    List<User> selectUsersByRoleAndName( @Param("queryname") String queryname , @Param("queryUserRole") Integer queryUserRole);

    User selectUserByCode(@Param("userCode") String userCode);

    /**
     * description: TODO 添加用户（包含新增的上传信息的字段）
     * create time: 2019/9/7 14:12
     * [user]
     * @return int
     * @param user
     */
    int insertSelective(User user);

    /**
     * description: TODO 根据id查找用户信息
     * create time: 2019/9/8 20:36
     * [userId]
     * @return com.bdqn.pojo.User
     */
    User selectUserById1(@Param("userId")Integer userid);

    /**
     * @Description: TODO 修改用户信息
     * @Param:  * @param user
     * @return:
     * @Author: xqj
     * @Date:
     */
    Integer updateUserByUser(User user);
}
