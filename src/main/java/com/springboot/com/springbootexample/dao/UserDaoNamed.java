package com.springboot.com.springbootexample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.com.springbootexample.entity.User;

/**
 * 
* <p>Title: UserDaoNamed</p>  
* <p>Description: jdbcTemplate的增强 NamedParameterJdbcTemplate使用参数可用:xxx站位</p>  
* @author daihu  
* @date 2019年5月5日
 */
@Repository
public class UserDaoNamed {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public User getUser(Long id) {
		String sql = "select * from user where id=:id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);
		User user =namedParameterJdbcTemplate.queryForObject(sql, paramMap, new UserRowMapper());
		return user;
	}
	
	static class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setLoginName(rs.getString("login_name"));
			user.setPassword(rs.getString("password"));
			user.setDate(rs.getDate("date"));
			user.setPhone(rs.getString("phone"));
			return user;
		}
		
	}
}
