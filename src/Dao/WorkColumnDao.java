package Dao;

import java.util.List;

import Bean.WorkColumnBean;

public interface WorkColumnDao {
	public int addcol(WorkColumnBean wcb, int state);
	public void changeCol(WorkColumnBean wcb,WorkColumnBean wcb1);
	public void addcolContent(WorkColumnBean wcb, String Content);
	public void updatstate(String teaid,int worid,int state,int state1,int worid2);
	public void updatecol(String teaid, int worid, String state, String colid, String colname);

	public void updatecolcontent(WorkColumnBean wcb, String content);

	public void deletecol(String teaid, int worid, String state, String colid);
	public void deleteworkcol(String teaid, int worid, int state);
	public void deletecolcontent(String teaid, int worid, String state, String colid);

	public List<WorkColumnBean> query();

	public List<WorkColumnBean> queryTC(String teaid, int worid, int state);

	public WorkColumnBean get(String teaid, int worid, int state, int colid);

	public String getContent(String teaid, int worid, String state, String colid);

	public int getColNo(String teaid, int worid, String state);
}
