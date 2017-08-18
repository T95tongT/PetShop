package com.toto.service;

import com.toto.mapper.CartMapper;
import com.toto.mapper.OrdersMapper;
import com.toto.model.Cart;
import com.toto.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
@Service
@Transactional
public class CartSerImp {
    @Autowired
    CartMapper dao;
    @Autowired
    private OrdersMapper odao;

    public int addCart(Map map){
        return dao.addCart(map);
    }
    public int delCart(Map map){
        return dao.delCart(map);
    }
    public List<Cart> queryCart(Map map){
        return dao.queryCart(map);
    }
    public int upCart(Map map){
        return dao.updateCart(map);
    }

    public int updateByPrimaryKeySelective(Orders record){
        return odao.updateByPrimaryKeySelective(record);
    }
}
