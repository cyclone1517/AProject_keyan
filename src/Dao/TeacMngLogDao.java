package Dao;

import java.sql.Date;
import java.util.List;

import Bean.TeacMngLogBean;
public interface TeacMngLogDao {
	public void addTMLog(TeacMngLogBean TMLB);//������־
	public void delTMLog(String Tch_no,String Mng_no,Date operTime);//ɾ����־
	public void updateTLog(TeacMngLogBean TMLB);
	public List<TeacMngLogBean> query();// ����������־
	public List<TeacMngLogBean> queryMno(String Mid);// ͨ������Ա��Ų�����־
	public List<TeacMngLogBean> queryTno(String Tid);// ͨ��ҵ�����Ա������־
	public List<TeacMngLogBean> queryOt(Date operTime1,Date operTime2);// ͨ��ʱ�������־
	public List<TeacMngLogBean> queryOn(int oper_no);//ͨ���������������־
}
