package springstudy.dao;

import java.util.List;

import springstudy.vo.UserVO;



public interface UserDao {
	public void insert(UserVO user);

	public List<UserVO> readAll();

	public int update(UserVO user);

	public void delete(String id);

	public UserVO read(String id);

}
