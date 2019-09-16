package com.bdqn.service;

import com.bdqn.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * @Description: 角色业务接口
 * @Author: anyanglai
 * @Date: 2019/8/28 12:02
 * @Param:
 * @return:
 **/
public interface RoleService {
    /*
     * @Description: 查找角色数量
     * @Author: anyanglai
     * @Date: 2019/8/28 10:56
     * @Param: []
     * @return: int
     **/
    int findRoleCount();

    /*
     * @Description: 查询角色数据
     * @Author: anyanglai
     * @Date: 2019/8/28 17:36
     * @Param:
     * @return:
     **/
    List<Role> finderRoles();
    
    /*
     * @Description: 查询某条角色数据
     * @Author: anyanglai
     * @Date: 2019/8/20 16:29
     * @Param: []
     * @return: int
     **/
    List<Role> findRoleById(@Param("id") Integer id);

    /*
     * @Description: 通过用户名模糊查询角色
     * @Author: anyanglai
     * @Date: 2019/8/21 13:45
     * @Param: [username]
     * @return: com.bdqn.pojo.User
     **/
    List<Role> findRoleByRoleName(@Param(value = "roleName") String roleName);

    /*
     * @Description: 通过角色名或用户的code模糊查询角色
     * @Author: anyanglai
     * @Date: 2019/8/21 14:00
     * @Param: [user]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserByUser(@Param("r") Role role);

    /*
     * @Description: 通过角色名称查询到用户信息
     * @Author: anyanglai
     * @Date: 2019/8/21 14:33
     * @Param: [roleName]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserByRoleName(@Param(value = "roleName") String roleName);

    /*
     * @Description: 通过角色id查询到用户信息（角色信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:05
     * @Param: [userRole]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserByUserRole(@Param(value = "userRole") Integer userRole);

    List<Role> findUserByUserRoleAndUserNamePaged(@Param(value = "userRole") Integer userRole,
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
    List<Role> findUserByUserRoleArray(Integer[] userRoles);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）集合入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserByUserRoleList(List<Integer> userRoleList);
    /*
     * @Description: 通过角色id查询到用户信息（角色信息）Map入参
     * @Author: anyanglai
     * @Date: 2019/8/22 16:26
     * @Param: [userRoles]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserByUserRoleMap(Map<String, Object> userRoleMap);

    /*
     * @Description: 通过id查询到用户地址信息（用户其他信息）
     * @Author: anyanglai
     * @Date: 2019/8/21 20:08
     * @Param: [id]
     * @return: java.util.List<com.bdqn.pojo.User>
     **/
    List<Role> findUserAddressByUserId(@Param(value = "id") Integer id);

    /*
     * @Description: 添加用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:09
     * @Param: [user]
     * @return: int
     **/
//    int insertUser(User user);
    int addUser(@Param(value = "user") Role user);

    /*
     * @Description: 修改用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param: [user]
     * @return: int
     **/
    int modifyUser(@Param(value = "user") Role user);

    /*
     * @Description: 删除用户
     * @Author: anyanglai
     * @Date: 2019/8/21 20:10
     * @Param:
     * @return:
     **/
    int deleteUser(@Param("uId") Integer uId);

    List<Role> findRoles();
}
