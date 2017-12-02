package Dao;

import java.util.List;

import Bean.ManagerBean;

public interface ManagerDao {
	public ManagerBean login(String userno, String password);// ͨ���û���ź������¼

	public void addManager(ManagerBean manager);// ��ӹ���Ա

	public void updateManager(ManagerBean manager);// ���¹���Ա

	public void delManager(String managerno);// ɾ������Ա

	public List<ManagerBean> query();// �������й���Ա

	public List<ManagerBean> queryno(String id);// ͨ����Ų��ҹ���Ա

	public List<ManagerBean> querydpmt(String dpmt);// ͨ��Ժϵ���ҹ���Ա

	public List<ManagerBean> queryname(String name);// ͨ���������ҹ���Ա

	public List<ManagerBean> queryIdno(int idtfy, String id);// ͨ����ݺͱ�Ų��ҹ���Դ

	public List<ManagerBean> queryIddpmt(int idtfy, String dpmt);// ͨ����ݺ�Ժϵ���ҹ���Ա

	public List<ManagerBean> queryIdname(int idtfy, String name);// ͨ����ݺ��������ҹ���Ա
	
	public List<ManagerBean> queryIdent(int idtfy);
	
	public ManagerBean get(String id);
}
