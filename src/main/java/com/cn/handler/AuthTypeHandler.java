package com.cn.handler;

import com.cn.constant.AuthType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: ReZero
 * @Date: 5/1/19 5:19 PM
 * @Version 1.0
 */
public class AuthTypeHandler implements TypeHandler<AuthType> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, AuthType authType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, authType.getCode());
    }

    @Override
    public AuthType getResult(ResultSet resultSet, String s) throws SQLException {
        return AuthType.getEnum(resultSet.getInt(s));
    }



    @Override
    public AuthType getResult(ResultSet resultSet, int i) throws SQLException {
        return AuthType.getEnum(resultSet.getInt(i));
    }

    @Override
    public AuthType getResult(CallableStatement callableStatement, int i) throws SQLException {
        return AuthType.getEnum(callableStatement.getInt(i));
    }
}
