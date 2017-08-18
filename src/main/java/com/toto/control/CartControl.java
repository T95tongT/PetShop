package com.toto.control;

import com.toto.model.Cart;
import com.toto.model.Orders;
import com.toto.service.CartSerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartControl {
    @Autowired
    CartSerImp service;
    @RequestMapping("/add")
    public ResponseEntity<String> addCart(@RequestBody Cart cart){
        Map map=new HashMap<>();
        map.put("in_username",cart.getUsername());
        map.put("in_itemid",cart.getItemid());
        map.put("in_quantity",cart.getQuantity());
        service.addCart(map);
        String orderid=map.get("out_orderid").toString();
        return new ResponseEntity<String>(orderid, HttpStatus.CREATED);
    }


    @RequestMapping(value="/query",method = RequestMethod.POST)
    public ResponseEntity<List<Cart>> queryCart(@RequestBody Cart cart){
        Map map=new HashMap();
        map.put("in_username",cart.getUsername());

        map.put("in_orderid",cart.getOrderid());

        List <Cart>list=service.queryCart(map);
        //得到输出参数


        //把oid送到前端
        return new ResponseEntity<List<Cart>>(list,HttpStatus.OK);
    }

    @RequestMapping(value="/del",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delCart(@RequestBody Cart cart){
        Map map=new HashMap();
        map.put("in_username",cart.getUsername());
        map.put("in_itemid",cart.getItemid());
        map.put("in_orderid",cart.getOrderid());

        service.delCart(map);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/up",method = RequestMethod.PUT)
    public ResponseEntity<Void> upCart(@RequestBody Cart cart){
        Map map=new HashMap();
        map.put("in_username",cart.getUsername());
        map.put("in_itemid",cart.getItemid());
        map.put("in_quantity",cart.getQuantity());
        map.put("in_orderid",cart.getOrderid());

        service.upCart(map);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value="/checkout",method = RequestMethod.PUT)
    public ResponseEntity<Void> checkOrders(@RequestBody Orders orders){



        service.updateByPrimaryKeySelective(orders);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
