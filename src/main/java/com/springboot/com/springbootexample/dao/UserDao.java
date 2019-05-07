package com.springboot.com.springbootexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.springboot.com.springbootexample.entity.User;

/**
 * 
* <p>Title: UserDao</p>  
* <p>Description: 使用JDBC Template 参数的占位符只能使用?</p>  
* @author daihu  
* @date 2019年5月5日
 */
@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUser(Long id) {
		User user = jdbcTemplate.queryForObject("select * from user where id=?",new UserRowMapper(),id);
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
	//修改操作
	public int update(User user) {
		String sql="update user set login_name=?,password=?,date=?,phone=?";
		int result =jdbcTemplate.update(sql, user.getLoginName(),user.getPassword(),user.getDate(),user.getPhone());
		return result;
	}
	//插入操作
	public Long inserUser(User user) {
		String sql="insert into user(login_name,password,date,phone) values(?,?,?,?)";
		//如果数据类型是插入，操作update对于mysql sql server 等数据库，含有自增序列，则需要提供一个KeyHolder来放置返回的序列
		//包含了自增长的结果，正如前面所说的，这并不能确定其序列类型因此需要根据业务要求转化为int或者long类型
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//指出自增主键的列名
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, user.getLoginName());
				ps.setString(2, user.getPassword());
				ps.setDate(3, new java.sql.Date(user.getDate().getTime()));
				ps.setString(4, user.getPhone());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}
}
