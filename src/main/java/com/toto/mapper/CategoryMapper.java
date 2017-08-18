package com.toto.mapper;

import com.toto.model.Category;
import com.toto.model.CategoryExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CategoryMapper {
    @SelectProvider(type=CategorySqlProvider.class, method="countByExample")
    int countByExample(CategoryExample example);

    @DeleteProvider(type=CategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CategoryExample example);

    @Delete({
        "delete from category",
        "where catid = #{catid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String catid);

    @Insert({
        "insert into category (catid, name, ",
        "descn)",
        "values (#{catid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{descn,jdbcType=VARCHAR})"
    })
    int insert(Category record);

    @InsertProvider(type=CategorySqlProvider.class, method="insertSelective")
    int insertSelective(Category record);

    @SelectProvider(type=CategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="catid", property="catid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectByExample(CategoryExample example);

    @Select({
        "select",
        "catid, name, descn",
        "from category",
        "where catid = #{catid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="catid", property="catid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(String catid);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update category",
        "set name = #{name,jdbcType=VARCHAR},",
          "descn = #{descn,jdbcType=VARCHAR}",
        "where catid = #{catid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Category record);
}