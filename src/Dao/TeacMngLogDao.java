package Dao;

import java.sql.Date;
import java.util.List;

import Bean.TeacMngLogBean;
public interface TeacMngLogDao {
	public void addTMLog(TeacMngLogBean TMLB);//增加日志
	public void delTMLog(String Tch_no,String Mng_no,Date operTime);//删除日志
	public void updateTLog(TeacMngLogBean TMLB);
	public List<TeacMngLogBean> query();// 查找所有日志
	public List<TeacMngLogBean> queryMno(String Mid);// 通过管理员编号查找日志
	public List<TeacMngLogBean> queryTno(String Tid);// 通过业务管理员查找日志
	public List<TeacMngLogBean> queryOt(Date operTime1,Date operTime2);// 通过时间查找日志
	public List<TeacMngLogBean> queryOn(int oper_no);//通过操作种类查找日志
}
