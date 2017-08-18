package com.toto.control;

import com.toto.model.Category;
import com.toto.model.Item;
import com.toto.model.Product;
import com.toto.service.CategorySerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@RestController
@CrossOrigin
@RequestMapping("/pet")
public class CateGoryControl {
    @Autowired
    CategorySerImp service;
    @RequestMapping("/habbit")
    public ResponseEntity<List<Category>> habbit(){
       List<Category> list= service.habbit();
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }

    //根据种类查询产品
    @RequestMapping(value = "/pro/{cate}",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> queryPro(@PathVariable String cate){

        List<Product> list=service.selectProByCate(cate);

        return new ResponseEntity(list, HttpStatus.CONFLICT.OK);
    }
    //根据产品查询多个项目
    @RequestMapping(value = "/items/{pro}",method = RequestMethod.GET)
    public ResponseEntity<List<Item>> queryItem(@PathVariable String pro){
        List<Item> list=service.selectIteByPro(pro);
        return new ResponseEntity<List<Item>>(list,HttpStatus.CONFLICT.OK);
    }
    //根据项目ID查询具体x项目
    @RequestMapping(value = "/item/{itemid}",method = RequestMethod.GET)
    public ResponseEntity<Item> selectItemById(@PathVariable String itemid){
        Item item=service.selectItemById(itemid);
        return new ResponseEntity(item,HttpStatus.OK);
    }
}
