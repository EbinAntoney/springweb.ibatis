package com.archie.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.archie.dao.UserDao;
import com.archie.model.User;
import com.archie.util.Pages;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user){
		return userDao.getUserByUnameUpwd(user);
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public void addUser(User user){
		userDao.addUser(user);
	}
	/**
	 * 根据ID删除
	 * @param uid
	 * @return
	 */
	public void deleteUser(int uid){
		userDao.deleteUser(uid);
	}
	/**
	 * 根据ID查询
	 * @param uid
	 * @return
	 */
	public User getUserById(int uid){
		return userDao.getUserByUid(uid);
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	/**
	 * 用户分页
	 * @param pageNo
	 * @return
	 */
	public Pages<User> getUserByPageNo(int pageNo){
		return userDao.getUserByPageNo(pageNo);
	}
	
}
