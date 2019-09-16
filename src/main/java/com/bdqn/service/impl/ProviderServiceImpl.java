package com.bdqn.service.impl;

import com.bdqn.dao.ProviderMapper;
import com.bdqn.pojo.Provider;
import com.bdqn.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProviderServiceImpl
 * @Description: 供应商的业务接口实现类
 * @Author: xyf
 * @Date 2019/7/2 14:55
 */
@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    /**
     * @Description: 获取供应商数量
     * @param: []
     * @return: int
     * @Date: 2019/07/02 14:55
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer getCountOfProviders() {
        return providerMapper.selectCount();
    }

    /**
     * @Description:查询所有的供应商信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:11
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Provider> findAllProviders() {
        List<Provider> list=providerMapper.selectAll();
        if (list==null){
            return null;
        }
        return list;
    }

    /**
     * @Description: 根据供应商名称查询供应商信息
     * @param: []
     * @return: java.util.List<com.bdqn.pojo.Provider>
     * @Date: 2019/07/02 15:15
     */
    @Override
    public List<Provider> findProviderByName(String proName) {
        return providerMapper.selectByProName(proName);
    }
}
