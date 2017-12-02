package Dao;

import java.util.List;
import Bean.RoleOfUserBean;

public interface RoleOfUserDao {
	public void addRU(int Roleno,String Userno);//���ӽ�ɫ����Ա��Ӧ
	public void delRU(int Roleno,String Userno);//ɾ����ɫ����Ա��Ӧ
	public void del(String Userno);
	public List<RoleOfUserBean> query();//����������Ŀ
	public List<RoleOfUserBean> queryRno(int rno);//���ݽ�ɫ��Ų�����Ŀ
	public List<String> queryUserno(String uno);//�����û���Ų�����Ŀ,�õ�ͬһ�û��ĵ����н�ɫ����
	public List<RoleOfUserBean> queryRU(int rno,String uno);//���ݽ�ɫ��ź��û���Ų��Ҷ�Ӧ��Ŀ
}
