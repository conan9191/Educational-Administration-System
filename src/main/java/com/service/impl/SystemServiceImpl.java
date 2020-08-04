package com.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;















import com.dao.IMenuDao;
import com.dao.IModuleDao;
import com.dao.IRoleDao;
import com.dao.IUserDao;
import com.dao.IUser_RoleDao;
import com.domain.UserModel;
import com.pojo.Menu;
import com.pojo.Module;
import com.pojo.Role;
import com.pojo.User;
import com.pojo.User_Role;
import com.service.ISystemService;

@Service("systemService")
@Transactional 
public class SystemServiceImpl implements ISystemService {
	
	@Resource
	private IModuleDao moduleDao;
	@Resource
    private IMenuDao menuDao;
	@Resource
    private IRoleDao roleDao;
	@Resource
    private IUserDao userDao;
	@Resource
    private IUser_RoleDao userRoleDao;
	@Override
	public int addModule(Module record) {
		// TODO Auto-generated method stub
		return moduleDao.insert(record);
	}
	@Override
	public int deleteModule(int id) {
		// TODO Auto-generated method stub
		return moduleDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Module> getAllModules() {
		// TODO Auto-generated method stub
		return moduleDao.selectAllModules();
	}
	@Override
	public Module getOneModule(int id) {
		// TODO Auto-generated method stub
		return moduleDao.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateModule(Module record) {
		// TODO Auto-generated method stub
		return moduleDao.updateByPrimaryKey(record);
	}
	@Override
	public int addMenu(Menu record) {
		// TODO Auto-generated method stub
		return menuDao.insert(record);
	}
	
	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return menuDao.selectAllMenus();
	}
	@Override
	public Menu getOneMenu(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectByPrimaryKey(id);
	}
  
	@Override
	public int deleteMenu(int id) {
		// TODO Auto-generated method stub
		Menu record = menuDao.selectByPrimaryKey(id);
		if(record.getParentId()!=null){
			List<Menu> childrenList = menuDao.selectAllChildrenMenus(record.getId());
			Iterator<Menu> it = childrenList.iterator();
			Menu tmp = new Menu();
			while(it.hasNext()){
				tmp = (Menu)it.next();
				menuDao.deleteByPrimaryKey(tmp.getId());
			}
		}
		return menuDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public int addRole(Role record) {
		// TODO Auto-generated method stub
		return roleDao.insert(record);
	}
	@Override
	public int deleteRole(int id) {
		// TODO Auto-generated method stub
		return roleDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.selectALlRoles();
	}
	
	
	
	@Override
	public int addUser(UserModel record) {
		// TODO Auto-generated method stub
		//在用户角色表也添加纪录
		User user = new User();
		user.setUsername(record.getUsername());
		user.setPassword(record.getPassword());
		userDao.insert(user);
		User insertedUser = userDao.selectByUsername(user.getUsername());
		User_Role userRole = new User_Role();
		userRole.setUserId(insertedUser.getId());
		Role role = roleDao.selectRoleByName(record.getRoleName());
		userRole.setRoleId(role.getId());
		return userRoleDao.insert(userRole);
	}
	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		//同时删除用户角色表的纪录
		userRoleDao.deleteRoleByUserId(userId);
		return userDao.deleteByPrimaryKey(userId);
	}
	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> userList = userDao.selectAllUsers();
		List<UserModel> userModelList = new ArrayList<UserModel>(); 
		Iterator<User> it = userList.iterator();
		User user = null;
		Role role = null;
		while(it.hasNext()){
			user = (User)it.next();
			UserModel um = new UserModel();
			um.setUserId(user.getId());
			um.setUsername(user.getUsername());
			um.setPassword(user.getPassword());
			role = roleDao.selectRoleByUserId(user.getId());
			um.setRoleName(role.getName());
			userModelList.add(um);
		}
		return userModelList;
	}
	@Override
	public User getActiveUser(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}
	
}
