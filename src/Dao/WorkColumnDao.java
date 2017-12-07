package Dao;

import Bean.WorkColumnBean;

public interface WorkColumnDao {
	public void addcol(WorkColumnBean wcb);
	public void addcolContent(WorkColumnBean wcb);
	public void updatecol(String teaid,String worid,String state,String colid);
	public void updatecolcontent(String teaid,String worid,String state,String colid,String content);
	public void deletecol(String teaid,String worid,String state,String colid);
	public void deletecolcontent(String teaid,String worid,String state,String colid);
}
