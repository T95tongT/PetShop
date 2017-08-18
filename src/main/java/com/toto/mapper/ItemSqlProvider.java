package com.toto.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.toto.model.Item;
import com.toto.model.ItemExample.Criteria;
import com.toto.model.ItemExample.Criterion;
import com.toto.model.ItemExample;
import java.util.List;
import java.util.Map;

public class ItemSqlProvider {

    public String countByExample(ItemExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("item");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ItemExample example) {
        BEGIN();
        DELETE_FROM("item");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Item record) {
        BEGIN();
        INSERT_INTO("item");
        
        if (record.getItemid() != null) {
            VALUES("itemid", "#{itemid,jdbcType=VARCHAR}");
        }
        
        if (record.getProductid() != null) {
            VALUES("productid", "#{productid,jdbcType=VARCHAR}");
        }
        
        if (record.getListprice() != null) {
            VALUES("listprice", "#{listprice,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitcost() != null) {
            VALUES("unitcost", "#{unitcost,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr1() != null) {
            VALUES("attr1", "#{attr1,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr2() != null) {
            VALUES("attr2", "#{attr2,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr3() != null) {
            VALUES("attr3", "#{attr3,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr4() != null) {
            VALUES("attr4", "#{attr4,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr5() != null) {
            VALUES("attr5", "#{attr5,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ItemExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("itemid");
        } else {
            SELECT("itemid");
        }
        SELECT("productid");
        SELECT("listprice");
        SELECT("unitcost");
        SELECT("status");
        SELECT("attr1");
        SELECT("attr2");
        SELECT("attr3");
        SELECT("attr4");
        SELECT("attr5");
        FROM("item");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Item record = (Item) parameter.get("record");
        ItemExample example = (ItemExample) parameter.get("example");
        
        BEGIN();
        UPDATE("item");
        
        if (record.getItemid() != null) {
            SET("itemid = #{record.itemid,jdbcType=VARCHAR}");
        }
        
        if (record.getProductid() != null) {
            SET("productid = #{record.productid,jdbcType=VARCHAR}");
        }
        
        if (record.getListprice() != null) {
            SET("listprice = #{record.listprice,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitcost() != null) {
            SET("unitcost = #{record.unitcost,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr1() != null) {
            SET("attr1 = #{record.attr1,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr2() != null) {
            SET("attr2 = #{record.attr2,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr3() != null) {
            SET("attr3 = #{record.attr3,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr4() != null) {
            SET("attr4 = #{record.attr4,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr5() != null) {
            SET("attr5 = #{record.attr5,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("item");
        
        SET("itemid = #{record.itemid,jdbcType=VARCHAR}");
        SET("productid = #{record.productid,jdbcType=VARCHAR}");
        SET("listprice = #{record.listprice,jdbcType=DECIMAL}");
        SET("unitcost = #{record.unitcost,jdbcType=DECIMAL}");
        SET("status = #{record.status,jdbcType=VARCHAR}");
        SET("attr1 = #{record.attr1,jdbcType=VARCHAR}");
        SET("attr2 = #{record.attr2,jdbcType=VARCHAR}");
        SET("attr3 = #{record.attr3,jdbcType=VARCHAR}");
        SET("attr4 = #{record.attr4,jdbcType=VARCHAR}");
        SET("attr5 = #{record.attr5,jdbcType=VARCHAR}");
        
        ItemExample example = (ItemExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Item record) {
        BEGIN();
        UPDATE("item");
        
        if (record.getProductid() != null) {
            SET("productid = #{productid,jdbcType=VARCHAR}");
        }
        
        if (record.getListprice() != null) {
            SET("listprice = #{listprice,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitcost() != null) {
            SET("unitcost = #{unitcost,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr1() != null) {
            SET("attr1 = #{attr1,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr2() != null) {
            SET("attr2 = #{attr2,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr3() != null) {
            SET("attr3 = #{attr3,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr4() != null) {
            SET("attr4 = #{attr4,jdbcType=VARCHAR}");
        }
        
        if (record.getAttr5() != null) {
            SET("attr5 = #{attr5,jdbcType=VARCHAR}");
        }
        
        WHERE("itemid = #{itemid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(ItemExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}