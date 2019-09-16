package com.bdqn.service;

import com.bdqn.pojo.Provider;

import java.util.List;

/**
 * @ClassName: ProviderService
 * @Description: 供应商的业务接口
 * @Author: xyf
 * @Date 2019/7/2 14:54
 */
public interface ProviderService {
    /**
     * @Description: 获取供应商数量
     * @param: []
     * @return: int
     * @Date: 2019/07/02 14:55
     */
    Integer getCountOfProviders();

    /**
     * @Description:查询所有的供应商信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:11
     */
    List<Provider> findAllProviders();

    /**
     * @Description: 根据供应商名称查询供应商信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:15
     */
    List<Provider> findProviderByName(String proName);
}
