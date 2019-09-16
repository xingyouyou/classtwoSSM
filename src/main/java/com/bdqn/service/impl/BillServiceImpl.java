package com.bdqn.service.impl;

import com.bdqn.dao.BillMapper;
import com.bdqn.pojo.Bill;
import com.bdqn.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BillServiceImpl
 * @Description: 订单的业务接口实现类
 * @Author: xyf
 * @Date 2019/7/2 15:22
 */
@Service("billService")
public class BillServiceImpl implements BillService{

    @Autowired
    private BillMapper billMapper;
    /**
     * @param bill
     * @Description: 订单列表的查询
     * @param: [bill]
     * @return: java.util.List<com.bdqn.pojo.Bill>
     * @Date: 2019/07/02 15:24
     */
    @Override
    public List<Bill> findBillByConditions(Bill bill) {
        return billMapper.selectBillsByConditions(bill);
    }
}
