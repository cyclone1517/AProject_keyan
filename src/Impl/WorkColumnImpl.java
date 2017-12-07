package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.WorkColumnBean;
import Bean.WorksBean;
import Dao.WorkColumnDao;
import Util.Util;
import columnXML.CreatXML;
import columnXML.delXML;

public class WorkColumnImpl implements WorkColumnDao {

	@Override
	public void addcol(WorkColumnBean wcb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addcolContent(WorkColumnBean wcb,String content) {
		// TODO Auto-generated method stub
		String state1=String.valueOf(wcb.getState());
		new CreatXML().addColContent(wcb.getTch_no(),wcb.getWrk_no(),state1,wcb.getCol_no(),content);
	}

	@Override
	public void updatecol(String teaid, String worid, String state, String colid,String colname) {
		// TODO Auto-generated method stub
		String sql="update WorkColumn set Col_name=? where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,colname);
			ptmt.setString(2,teaid);
			ptmt.setString(3,worid);
			ptmt.setString(4,state);
			ptmt.setString(5,colid);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}


	}

	@Override
	public void updatecolcontent(WorkColumnBean wcb, String content) {
		// TODO Auto-generated method stub
		String state1=String.valueOf(wcb.getState());
		new CreatXML().addColContent(wcb.getTch_no(),wcb.getWrk_no(),state1,wcb.getCol_no(),content);
	}

	@Override
	public void deletecol(String teaid, String worid, String state, String colid) {
		// TODO Auto-generated method stub
		String sql="delete from WorkColumn where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setString(2,worid);
			ptmt.setString(3,state);
			ptmt.setString(4,colid);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		new delXML().delColElement(teaid,worid,state,colid);


	}

	@Override
	public void deletecolcontent(String teaid, String worid, String state, String colid) {
		// TODO Auto-generated method stub
		new delXML().delColContent(teaid,worid,state,colid);

	}

	@Override
	public WorkColumnBean get(String teaid, String worid, String state, String colid) {
		// TODO Auto-generated method stub
		String sql="select Col_name from WorkColumn where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setString(2,worid);
			ptmt.setString(3,state);
			ptmt.setString(4,colid);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				WorkColumnBean wb=new WorkColumnBean();
				wb.setCol_name(rs.getString("Col_name"));
				wb.setCol_no(colid);
				wb.setWrk_no(worid);
				wb.setTch_no(teaid);
				wb.setState(Integer.parseInt(state));
				return wb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return null;
	}

	@Override
	public String getContent(String teaid, String worid, String state, String colid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkColumnBean> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
