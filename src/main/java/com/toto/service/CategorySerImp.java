package com.toto.service;

import com.toto.mapper.CategoryMapper;
import com.toto.mapper.ItemMapper;
import com.toto.mapper.ProductMapper;
import com.toto.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@Service
@Transactional
public class CategorySerImp {
    @Autowired
    CategoryMapper dao;
    @Autowired
    ProductMapper pdao;
    @Autowired
    ItemMapper idao;
    public List<Category> habbit(){
        CategoryExample c=new CategoryExample();
        c.createCriteria().andCatidIsNotNull();
        return dao.selectByExample(c);
    }


    //根据种类查询产品
    public List<Product> selectProByCate(String cate){
        ProductExample example =new ProductExample();
        example.createCriteria().andCatidEqualTo(cate);
        return pdao.selectByExample(example);

    }
    //根据产品查询多个项目
    public List<Item> selectIteByPro(String pro){
        ItemExample itemExample=new ItemExample();
        itemExample.createCriteria().andProductidEqualTo(pro);
        return  idao.selectByExample(itemExample);
    }

    //根据项目ID查询具体x项目
    public Item selectItemById(String itemid){
        return idao.selectByPrimaryKey(itemid);
    }
}
