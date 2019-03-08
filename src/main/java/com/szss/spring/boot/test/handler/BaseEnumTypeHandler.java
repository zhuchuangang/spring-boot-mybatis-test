package com.szss.spring.boot.test.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/**
 *
 * @param <E>
 */
@MappedTypes(value = {InvoiceCodeEnum.class,GenderCodeEnum.class})
public class BaseEnumTypeHandler<E extends Enum> extends BaseTypeHandler<E> {
    /**
     * 类型
     */
    private Class<E> type;

    private Map<Object, E> map;

    public BaseEnumTypeHandler() {
    }

    public BaseEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("类型不能为空");
        }
        Class[] interfaces = type.getInterfaces();
        Boolean flag = false;
        for (Class clazz : interfaces) {
            if (clazz.equals(ICodeEnum.class)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("枚举必须实现ICodeEnum接口");
        }
        E[] enumConstants = type.getEnumConstants();
        map = new HashMap<Object, E>(enumConstants.length);
        for (E e : enumConstants) {
            ICodeEnum c = (ICodeEnum)e;
            map.put(c.getCode(), e);
        }
        this.type = type;
    }

    @Override public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType)
        throws SQLException {
        if (jdbcType == null) {
            ICodeEnum e = (ICodeEnum)parameter;
            //存在数据库字段类型隐式转换的问题
            ps.setString(i, e.getCode());
        } else {
            ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE);
        }
    }

    @Override public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getString(columnName));
    }

    @Override public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getString(columnIndex));
    }

    @Override public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getString(columnIndex));
    }

    //    private <E extends Enum> E get(String v) {
    //        if (v == null) {
    //            return null;
    //        }
    //        try {
    //            E x=null;
    //            Method method = type.getMethod("getCode");
    //            for (Object e: type.getEnumConstants()) {
    //                if (v.equals(method.invoke(e))){
    //                    x=(E)e;
    //                }
    //            }
    //            return x;
    //        }catch (Exception e){
    //            e.printStackTrace();
    //        }
    //        return null;
    //
    //    }

    private <E extends Enum> E get(String v) {
        if (v == null) {
            return null;
        }
        return (E)map.get(v);
    }
}