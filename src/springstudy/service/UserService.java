package springstudy.service;

import java.util.List;

import springstudy.vo.UserVO;


public interface UserService {
	
	public void insertUser(UserVO user);

	public List<UserVO> getUserList();

	public void deleteUser(String id);

	public UserVO getUser(String id);

	public void updateUser(UserVO user);
}
