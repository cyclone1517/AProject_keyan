package Dao;

import java.util.Date;
import java.util.List;

import Bean.WorksBean;

public interface WorksDao {
	public void addwork(WorksBean work);
	public int getvi_id();
	public void delwork(String Tch_no,String Wrk_no,int state);
	//改变成果状态：创建，提交，审核，发表；修改的话为增加一个创建/提交的表，审核后替换全来的发表的表，这些表编号相同
	//创建变提交
	public void changecreTosub(String Tch_no, String Wrk_no);
	//提交变审核
	public void changesubTopas(String Tch_no, String Wrk_no);
	//审核变禁用
	public void changepasTodel(String Tch_no, String Wrk_no);
	//搜索全部成果，默认为最新
	public List<WorksBean> query();
	//搜素某个教师已上传的成果，用于显示在个人成果中//搜素某个教师已创建的成果，用于显示在个人成果中
	public List<WorksBean> querycreid(String Tch_no,int state);
	//显示所有的已提交成果//显示所有的已审核成果
	public List<WorksBean> querystate(int state);
	//在已审核成果中安按成果编号搜索
	public List<WorksBean> queryalworkid(String Wrk_no);
	//按照主题，时间，和标签搜索
	public List<WorksBean> query(String Type_name,Date startTime,Date endTime,String wlabel);
	public List<WorksBean> querycli(String Type_name,Date startTime,Date endTime,String wlabel);
	//按照主题搜索
	public List<WorksBean> querytype(String Type_name);
	public List<WorksBean> querytypecli(String Type_name);
	//按照时间搜索
	public List<WorksBean> querytime(Date startTime,Date endTime);
	public List<WorksBean> querytimecli(Date startTime,Date endTime);
	//按照标签搜索
	public List<WorksBean> querylabel(String wlabel);
	public List<WorksBean> querylabelcli(String wlabel);
	//按照主题时间搜索
	public List<WorksBean> querytytime(String Type_name,Date startTime,Date endTime);
	public List<WorksBean> querytytimecli(String Type_name,Date startTime,Date endTime);
	//按主题标签搜索
	public List<WorksBean> querytylab(String Type_name,String wlabel);
	public List<WorksBean> querytylabcli(String Type_name,String wlabel);
	//按时间标签搜索
	public List<WorksBean> querylabtime(String wlabel,Date startTime,Date endTime);
	public List<WorksBean> querylabtimecli(String wlabel,Date startTime,Date endTime);
	public WorksBean get(String Tch_no,String Wrk_no,int state);
}
