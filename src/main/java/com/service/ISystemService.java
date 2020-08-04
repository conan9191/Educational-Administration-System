package com.service;

import java.util.List;






import com.domain.UserModel;
import com.pojo.Menu;
//import com.pojo.Menu;
import com.pojo.Module;
import com.pojo.Role;
import com.pojo.User;



public interface ISystemService {
	public int addModule(Module record);
	public int deleteModule(int id);
	public List<Module> getAllModules();
	public Module getOneModule(int id);
	public int updateModule(Module record);
	
	public int addMenu(Menu record);
	public int deleteMenu(int id);
	public List<Menu> getAllMenus();
	public Menu getOneMenu(int id);
	
	public int addRole(Role record);
	public int deleteRole(int id);
	public List<Role> getAllRoles();
	
	public int addUser(UserModel record);
	public int deleteUser(int userId);
	public List<UserModel> getAllUsers();
	public User getActiveUser(String username);

	
}
