package Dao;

import java.sql.Date;
import java.util.List;

import Bean.MngerMngLogBean;

public interface MngerMngLogDao {
	public void addMMLog(MngerMngLogBean MMLB);//增加日志
	public void delMMLog(String Sys_Mng_no,String Mng_no,Date operTime);//删除日志
	public void updateMLog(MngerMngLogBean MMLB);
	public List<MngerMngLogBean> query();// 查找所有日志
	public List<MngerMngLogBean> queryMno(String Mid);// 通过管理员编号查找日志
	public List<MngerMngLogBean> querySno(String Sid);// 通过业务管理员查找日志
	public List<MngerMngLogBean> queryOt(Date operTime1,Date operTime2);// 通过时间查找日志
	public List<MngerMngLogBean> queryOn(int oper_no);//通过操作种类查找日志
}
