package Dao;

import java.sql.Date;
import java.util.List;

import Bean.WorkCheckBean;

public interface WorkCheckDao {
	public void addwork(WorkCheckBean work);
	public void delwork(String Tch_no,int Wrk_no,int state,String Mng_no,Date operTime);
	public List<WorkCheckBean> query();//�������еĲ���
	public List<WorkCheckBean> query(String Tch_no,int Wrk_no,int state);//����ĳ���ɹ�����
	public List<WorkCheckBean> query(Date operTime);//���ݲ���ʱ�����
	public List<WorkCheckBean> query(String Mng_no);//���ݹ���Ա����
	public WorkCheckBean get(int oper_no);//���ݲ������Ͳ���
	public WorkCheckBean get(String Tch_no,int Wrk_no,int state,String Mng_no,Date operTime);
}
