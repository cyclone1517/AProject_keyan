package Dao;

import java.sql.Date;
import java.util.List;

import Bean.WorkCheckBean;

public interface WorkCheckDao {
	public void addwork(WorkCheckBean work);
	public void delwork(String Tch_no,int Wrk_no,int state,String Mng_no,Date operTime);
	public List<WorkCheckBean> query();//朝找所有的操作
	public List<WorkCheckBean> query(String Tch_no,int Wrk_no,int state);//根据某个成果查找
	public List<WorkCheckBean> query(Date operTime);//根据操作时间查找
	public List<WorkCheckBean> query(String Mng_no);//根据管理员查找
	public WorkCheckBean get(int oper_no);//根据操作类型查找
	public WorkCheckBean get(String Tch_no,int Wrk_no,int state,String Mng_no,Date operTime);
}
