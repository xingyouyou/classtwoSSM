package com.bdqn.service;

import com.bdqn.pojo.Bill;

import java.util.List;

/**
 * @ClassName: BillService
 * @Description: 订单的业务接口
 * @Author: xyf
 * @Date 2019/7/2 15:22
 */
public interface BillService {

    /**
     * @Description: 订单列表的查询
     * @param: [bill]
     * @return: java.util.List<com.bdqn.pojo.Bill>
     * @Date: 2019/07/02 15:24
     */
    List<Bill> findBillByConditions(Bill bill);
}

