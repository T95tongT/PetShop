package com.toto.mapper;

import com.toto.model.Cart;
import com.toto.model.CartExample;
import com.toto.model.CartKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    @Insert(value ="{ call addCart(" +
            "#{in_username , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_itemid , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_quantity , mode=IN ,jdbcType=INTEGER},"+
            "#{out_orderid , mode=OUT ,jdbcType=INTEGER}"+
            ")}" )
    @Options(statementType= StatementType.CALLABLE)//告诉mybatis，我是存储过程
    int addCart(Map map);

    @Update(value ="{ call updateCart(" +
            "#{in_username , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_itemid , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_quantity , mode=IN ,jdbcType=INTEGER},"+
            "#{in_orderid , mode=IN ,jdbcType=INTEGER}"+
            ")}" )
    @Options(statementType= StatementType.CALLABLE)//告诉mybatis，我是存储过程
    int updateCart(Map map);


    @Delete(value ="{ call delCart(" +
            "#{in_username , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_orderid , mode=IN ,jdbcType=INTEGER},"+
            "#{in_itemid , mode=IN ,jdbcType=VARCHAR}"+
            ")}" )
    @Options(statementType= StatementType.CALLABLE)//告诉mybatis，我是存储过程
    int delCart(Map map);


    @Select(value ="{ call queryCart(" +
            "#{in_username , mode=IN ,jdbcType=VARCHAR},"+
            "#{in_orderid , mode=IN ,jdbcType=INTEGER}"+
            ")}" )
    @Results({
            @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
            @Result(column="itemid", property="item", jdbcType=JdbcType.VARCHAR,
                    one =@One(select="com.toto.mapper.ItemMapper.selectByPrimaryKey") )
    })
    @Options(statementType= StatementType.CALLABLE)//告诉mybatis，我是存储过程
    List<Cart> queryCart(Map map);



    @SelectProvider(type=CartSqlProvider.class, method="countByExample")
    int countByExample(CartExample example);

    @DeleteProvider(type=CartSqlProvider.class, method="deleteByExample")
    int deleteByExample(CartExample example);

    @Delete({
        "delete from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(CartKey key);

    @Insert({
        "insert into cart (orderid, itemid, ",
        "username, quantity)",
        "values (#{orderid,jdbcType=INTEGER}, #{itemid,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{quantity,jdbcType=INTEGER})"
    })
    int insert(Cart record);

    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    List<Cart> selectByExample(CartExample example);

    @Select({
        "select",
        "orderid, itemid, username, quantity",
        "from cart",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER)
    })
    Cart selectByPrimaryKey(CartKey key);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cart record);

    @Update({
        "update cart",
        "set quantity = #{quantity,jdbcType=INTEGER}",
        "where orderid = #{orderid,jdbcType=INTEGER}",
          "and itemid = #{itemid,jdbcType=VARCHAR}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Cart record);
}