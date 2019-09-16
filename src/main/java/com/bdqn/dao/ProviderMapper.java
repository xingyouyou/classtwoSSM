package com.bdqn.dao;

import com.bdqn.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);

    /**
     * @Description: 供应商数量
     * @param: []
     * @return: java.lang.Integer
     * @Date: 2019/07/02 14:57
     */
    Integer selectCount();

    /**
     * @Description: 查询所有的供应商信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:11
     */
    List<Provider> selectAll();

    /**
     * @Description:通过名称模糊查询到供应商信息
     * @param: [proName]
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:17
     */
    List<Provider> selectByProName(@Param("proName") String proName);
}