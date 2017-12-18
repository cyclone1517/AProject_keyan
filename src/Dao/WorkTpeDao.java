package Dao;

import java.util.List;

import Bean.WorkTpeBean;

public interface WorkTpeDao {
	public void addworktpe(WorkTpeBean worktype);
	public void delworktpe(String Type_ID);
	public void updateworktpe(String Type_ID,String Type_name);
	public List<WorkTpeBean> query();
}
