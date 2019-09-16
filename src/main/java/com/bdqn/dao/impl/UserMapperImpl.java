package com.bdqn.dao.impl;/*
package com.bdqn.dao.impl;

import com.bdqn.dao.UserMapper;
import javafx.scene.chart.ValueAxis;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

*/
/**
 * ClassName: UserMapperImpl$
 * Description:用户数据访问层接口实现类
 * Author: anyanglai
 * Date: 2019/8/28
 * Time: 11:00
 *//*

@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    @Qualifier(value = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    */
/*
     * @Description: 查询用户数量
     * @Author: anyanglai
     * @Date: 2019/8/28 11:03
     * @Param: []
     * @return: int
     **//*

    public int selectCount() {

//        return sqlSessionTemplate.selectOne("com.bdqn.dao.UserMapper.count");
        return sqlSessionTemplate.getMapper(UserMapper.class).selectCount();
    }
}
*/
