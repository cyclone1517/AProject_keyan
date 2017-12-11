package Impl;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Bean.ManagerBean;
import Bean.WorkColumnBean;
import Bean.WorksBean;
import Dao.WorkColumnDao;
import Util.Util;
import columnXML.CreatXML;
import columnXML.delXML;
import columnXML.parserXML;

public class WorkColumnImpl implements WorkColumnDao {

	@Override
	public void addcol(WorkColumnBean wcb,int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			CallableStatement cst=conn.prepareCall("{call addnewCol(?,?,?,?)}");
			cst.setString(1, wcb.getTch_no());
			cst.setString(2, wcb.getWrk_no());
			cst.setInt(3, state);
			cst.setString(4, wcb.getCol_name());
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		 }
		//String state1=String.valueOf(wcb.getState());
		//new CreatXML().addColElement(wcb.getTch_no(),wcb.getWrk_no(),state1,wcb.getCol_no());
	}
	
	//public void addalCol(WorkColumnBean wcb)
//	{
		//String sql1="select count(distinct Col_no)from WorkColumn where Tch_no=? and Wrk_no=? and state=?";
	//	String sql="insert into WorkColumn(Tch_no,Wrk_no,Col_name,) set Col_name=? where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		//Util util=new Util();
		//Connection conn=util.openConnection();
		//CallableStatement cst=conn.prepareCall("{call addnewCol(?,?,?,?)}");
		/*cst.setString(1, wcb.getTch_no());
		cst.setString(2, wcb.getWrk_no());
		cst.setInt(3, state);
		cst.setString(4, wcb.getCol_name());
		cst.execute();
		try{
			PreparedStatement ptmt1=conn.prepareStatement(sql1);
			ptmt.;
		}
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,wcb.colname);
			ptmt.setString(2,wcb.teaid);
			ptmt.setString(3,wcb.worid);
			ptmt.setString(4,wcb.state);
			ptmt.setString(5,wcb.colid);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		String state1=String.valueOf(wcb.getState());
		new CreatXML().addColElement(wcb.getTch_no(),wcb.getWrk_no(),state1,wcb.getCol_no());
//	}*/

	@Override
	public void addcolContent(WorkColumnBean wcb,String content) {
		// TODO Auto-generated method stub
		String state1=String.valueOf(wcb.getState());
		new CreatXML().addColContent(wcb.getTch_no(),wcb.getWrk_no(),state1,String.valueOf(wcb.getCol_no()),content);
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
		new CreatXML().addColContent(wcb.getTch_no(),wcb.getWrk_no(),state1,String.valueOf(wcb.getCol_no()),content);
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
	public WorkColumnBean get(String teaid, String worid, int state, int colid) {
		// TODO Auto-generated method stub
		String sql="select Col_name from WorkColumn where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setString(2,worid);
			ptmt.setInt(3,state);
			ptmt.setInt(4,colid);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				WorkColumnBean wb=new WorkColumnBean();
				wb.setCol_name(rs.getString("Col_name"));
				wb.setCol_no(colid);
				wb.setWrk_no(worid);
				wb.setTch_no(teaid);
				wb.setState(state);
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
		return new parserXML().getColContent(teaid, worid, state, colid);
	}

	@Override
	public List<WorkColumnBean> query() {
		Util util=new Util();
		Connection conn=util.openConnection();
		WorkColumnBean wcb=null;
		List<WorkColumnBean> works;
		works = new ArrayList<WorkColumnBean>();
		try {
		Statement stmt=conn.createStatement();//执行sql语句
		ResultSet rs=stmt.executeQuery("select * from WorkColumn");//执行后的结果放到结果集中	
		while(rs.next())
		{
			wcb=new WorkColumnBean();
			wcb.setWrk_no(rs.getString("Wrk_no"));
			wcb.setTch_no(rs.getString("Tch_no"));
			wcb.setState(rs.getInt("state"));
			wcb.setCol_no(rs.getInt("Col_no"));
			wcb.setCol_name(rs.getString("Col_name"));
			works.add(wcb);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(works.size());
		return works;
	}

	@Override
	public List<WorkColumnBean> queryTC(String teaid, String worid, int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		List<WorkColumnBean> works;
		works = new ArrayList<WorkColumnBean>();
		String sql="select * from WorkColumn where Tch_no=? and Wrk_no=? and state=?";
		try {
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, teaid);
		ptmt.setString(2, worid);
		ptmt.setInt(3, state);
		ResultSet rs=ptmt.executeQuery();
		WorkColumnBean wcb=null;
		while(rs.next())
		{
			wcb=new WorkColumnBean();
			wcb.setWrk_no(rs.getString("Wrk_no"));
			wcb.setTch_no(rs.getString("Tch_no"));
			wcb.setState(rs.getInt("state"));
			wcb.setCol_no(rs.getInt("Col_no"));
			wcb.setCol_name(rs.getString("Col_name"));
			works.add(wcb);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(works.size());
		return works;
	}

	@Override
	public int getColNo(String teaid, String worid, String state) {
		// TODO Auto-generated method stub
		return 0;
	}

}
