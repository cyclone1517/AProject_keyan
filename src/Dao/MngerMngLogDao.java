package Dao;

import java.sql.Date;
import java.util.List;

import Bean.MngerMngLogBean;

public interface MngerMngLogDao {
	public void addMMLog(MngerMngLogBean MMLB);//������־
	public void delMMLog(String Sys_Mng_no,String Mng_no,Date operTime);//ɾ����־
	public void updateMLog(MngerMngLogBean MMLB);
	public List<MngerMngLogBean> query();// ����������־
	public List<MngerMngLogBean> queryMno(String Mid);// ͨ������Ա��Ų�����־
	public List<MngerMngLogBean> querySno(String Sid);// ͨ��ҵ�����Ա������־
	public List<MngerMngLogBean> queryOt(Date operTime1,Date operTime2);// ͨ��ʱ�������־
	public List<MngerMngLogBean> queryOn(int oper_no);//ͨ���������������־
}
