package com.bdqn.dao;

import com.bdqn.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    /**
     * @Description: 多条件查询订单列表
     * @param: [bill]
     * @return: java.util.List<com.bdqn.pojo.Bill>
     * @Date: 2019/07/02 15:25
     */
    List<Bill> selectBillsByConditions(@Param("bill") Bill bill);
}