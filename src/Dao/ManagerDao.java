package Dao;

import java.util.List;

import Bean.ManagerBean;

public interface ManagerDao {
	public ManagerBean login(String userno, String password);// 通过用户编号和密码登录

	public void addManager(ManagerBean manager);// 添加管理员

	public void updateManager(ManagerBean manager);// 更新管理员

	public void delManager(String managerno);// 删除管理员

	public List<ManagerBean> query();// 查找所有管理员

	public List<ManagerBean> queryno(String id);// 通过编号查找管理员

	public List<ManagerBean> querydpmt(String dpmt);// 通过院系查找管理员

	public List<ManagerBean> queryname(String name);// 通过姓名查找管理员

	public List<ManagerBean> queryIdno(int idtfy, String id);// 通过身份和编号查找瓜沥源

	public List<ManagerBean> queryIddpmt(int idtfy, String dpmt);// 通过身份和院系查找管理员

	public List<ManagerBean> queryIdname(int idtfy, String name);// 通过身份和姓名查找管理员
	
	public List<ManagerBean> queryIdent(int idtfy);
	
	public ManagerBean get(String id);
}
