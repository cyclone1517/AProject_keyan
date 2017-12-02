package Dao;

import java.util.List;
import Bean.RoleOfUserBean;

public interface RoleOfUserDao {
	public void addRU(int Roleno,String Userno);//增加角色管理员对应
	public void delRU(int Roleno,String Userno);//删除角色管理员对应
	public void del(String Userno);
	public List<RoleOfUserBean> query();//查找所有条目
	public List<RoleOfUserBean> queryRno(int rno);//根据角色编号查找条目
	public List<String> queryUserno(String uno);//根据用户编号查找条目,得到同一用户的的所有角色名称
	public List<RoleOfUserBean> queryRU(int rno,String uno);//根据角色编号和用户编号查找对应条目
}
