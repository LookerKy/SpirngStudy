package springstudy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import springstudy.vo.UserVO;


@Repository("userDao")
public class UserDaoImplJDBC implements UserDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	class UserMapper implements RowMapper<UserVO> {
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setUserId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
	}
	
	@Override
	public UserVO read(String id) {	
		String SQL = "select * from users where userid = ?";
		try {
			UserVO user = jdbcTemplate.queryForObject(SQL,
					new Object[] { id }, new UserMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}	
	public void insert(UserVO user) {
		String SQL = "insert into users (userid, name, gender,city) values (?, ?, ?, ?)";
		jdbcTemplate.update(SQL, user.getUserId(), user.getName(), user.getGender(), user.getCity());
		
		System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	public List<UserVO> readAll() {
		String SQL = "select * from users"; 
		List<UserVO>  userList = jdbcTemplate.query(SQL, new UserMapper());
		return userList;
	}

	//@Override
	public void delete(String id) {
		String SQL = "delete from users where userid = ?"; 
		jdbcTemplate.update(SQL, id); 
		System.out.println("삭제된 Record with ID = " + id ); 
	}

	//@Override
	public int update(UserVO user) {
		StringBuffer updateQuery = new StringBuffer();
		updateQuery.append("update users set name = ?, gender = ?, city = ? where userid = ?"); 
		int result = this.jdbcTemplate.update(updateQuery.toString(), user.getName(), user.getGender(), user.getCity(),user.getUserId()); 
		System.out.println("갱신된 Record with ID = " + user.getUserId() );
		return  result;//반영된 레코드를 반환
	}



}
