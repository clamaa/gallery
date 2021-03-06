package com.baobaotao.dao;

import com.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: clamaa
 * Date: 14-3-2
 */
@Repository
public class UserDao {

    @Autowired
    @Qualifier("baobaotao")
    private JdbcTemplate jdbcTemplate;

    public User findUserByUserName(final String userName){
        String sqlStr = "SELECT user_id, user_name, password FROM t_user WHERE user_name=?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "UPDATE t_user SET last_visit=?, last_ip=?, credits=? WHERE user_id=?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }

    public int getMatchCount(String userName, String password){
        String sqlStr = "SELECT count(*) FROM t_user WHERE user_name=? and password=?";
        return jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{userName, password});
    }

    public void createUser(User user){
        String sqlStr = "INSERT INTO t_user(user_name, password, user_real_name) VALUES (?,?,?)";
        jdbcTemplate.update(sqlStr, new Object[]{user.getUserName(), user.getPassword(), user.getUserRealName()});
    }

}
