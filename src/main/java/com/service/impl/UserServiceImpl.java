package com.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  
import org.springframework.transaction.annotation.Transactional;

import com.dao.IUserDao;  
import com.dao.IUser_RoleDao;
import com.pojo.User;  
import com.pojo.User_Role;
import com.service.IUserService;  
  
@Service("userService")  
@Transactional 
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    @Resource
    private IUser_RoleDao userRoleDao;
    
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId); 
    }
	@Override
	public int register(User record) {
		// TODO Auto-generated method stub
				if(userDao.userIsExist(record.getUsername())>0){
					return 0;
				}else{
					userDao.insert(record);
					//设置注册用户的角色为学生
					User_Role userRoleRecord = new User_Role();
					User condition = userDao.selectByUsername(record.getUsername());
					userRoleRecord.setUserId(condition.getId());
					userRoleRecord.setRoleId(4);
					return userRoleDao.insert(userRoleRecord);
				}
	}
	@Override
	public int login(User record) {
		// TODO Auto-generated method stub
		return userDao.selectByUser(record);
	}
	@Override
	public User getUserCondition(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}
	
	
}