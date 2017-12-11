package Dao;

import java.util.List;

import Bean.WorkColumnBean;

public interface WorkColumnDao {
	public void addcol(WorkColumnBean wcb, int state);

	public void addcolContent(WorkColumnBean wcb, String Content);

	public void updatecol(String teaid, String worid, String state, String colid, String colname);

	public void updatecolcontent(WorkColumnBean wcb, String content);

	public void deletecol(String teaid, String worid, String state, String colid);

	public void deletecolcontent(String teaid, String worid, String state, String colid);

	public List<WorkColumnBean> query();

	public List<WorkColumnBean> queryTC(String teaid, String worid, int state);

	public WorkColumnBean get(String teaid, String worid, int state, int colid);

	public String getContent(String teaid, String worid, String state, String colid);

	public int getColNo(String teaid, String worid, String state);
}
