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

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

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
	public int addcol(WorkColumnBean wcb,int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		int num=0;
		try {
			CallableStatement cst=conn.prepareCall("{call addnewCol(?,?,?,?,?)}");
			cst.setString(1, wcb.getTch_no());
			cst.setInt(2, wcb.getWrk_no());
			cst.setInt(3, state);
			cst.setString(4, wcb.getCol_name());
			cst.registerOutParameter(5,  java.sql.Types.INTEGER); 
			//cst.setInt(5, num);
			cst.execute();
			num=cst.getInt(5);
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		 }
		//String state1=String.valueOf(wcb.getState());
		//new CreatXML().addColElement(wcb.getTch_no(),String.valueOf(wcb.getWrk_no()),state1,String.valueOf(getColNo(wcb.getTch_no(), wcb.getWrk_no(), String.valueOf(state))));
	return num;
	}
	public void changeCol(WorkColumnBean wcb,WorkColumnBean wcb1){
		String sql="insert into WorkColumn(Tch_no,Wrk_no,Col_name,Col_no) values(?,?,?,?);";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(3,wcb1.getCol_name());
			ptmt.setInt(2,wcb.getWrk_no());
			ptmt.setString(1,wcb1.getTch_no());
			ptmt.setInt(4,wcb1.getCol_no());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	public void updatstate(String teaid,int worid,int state,int state1,int worid2){
		String sql="update WorkColumn set Wrk_no=?,state=? where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1,worid2);
			ptmt.setInt(2,state1);
			ptmt.setString(3,teaid);
			ptmt.setInt(4,worid);
			ptmt.setInt(5,state);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

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
		new CreatXML().addColContent(wcb.getTch_no(),String.valueOf(wcb.getWrk_no()),state1,String.valueOf(wcb.getCol_no()),content);
	}

	@Override
	public void updatecol(String teaid, int worid, String state, String colid,String colname) {
		// TODO Auto-generated method stub
		String sql="update WorkColumn set Col_name=? where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,colname);
			ptmt.setString(2,teaid);
			ptmt.setInt(3,worid);
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
		new CreatXML().addColContent(wcb.getTch_no(),String.valueOf(wcb.getWrk_no()),state1,String.valueOf(wcb.getCol_no()),content);
	}

	@Override
	public void deletecol(String teaid, int worid, String state, String colid) {
		// TODO Auto-generated method stub
		String sql="delete from WorkColumn where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setInt(2,worid);
			ptmt.setString(3,state);
			ptmt.setString(4,colid);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		//new delXML().delColElement(teaid,String.valueOf(worid),state,colid);


	}
	public void deleteworkcol(String teaid, int worid, int state){
		String sql="delete from WorkColumn where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setInt(2,worid);
			ptmt.setInt(3,state);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	@Override
	public void deletecolcontent(String teaid, int worid, String state, String colid) {
		// TODO Auto-generated method stub
		new delXML().delColContent(teaid,String.valueOf(worid),state,colid);

	}

	@Override
	public WorkColumnBean get(String teaid, int worid, int state, int colid) {
		// TODO Auto-generated method stub
		String sql="select Col_name from WorkColumn where Tch_no=? and Wrk_no=? and state=? and Col_no =?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teaid);
			ptmt.setInt(2,worid);
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
	public String getContent(String teaid, int worid, String state, String colid) {
		// TODO Auto-generated method stub
		return new parserXML().getColContent(teaid, String.valueOf(worid), state, colid);
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
			wcb.setWrk_no(rs.getInt("Wrk_no"));
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
	public List<WorkColumnBean> queryTC(String teaid, int worid, int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		WorkColumnBean wcb=null;
		Connection conn=util.openConnection();
		List<WorkColumnBean> works;
		works = new ArrayList<WorkColumnBean>();
		String sql="select * from WorkColumn where Tch_no=? and Wrk_no=? and state=?";
		try {
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, teaid);
		ptmt.setInt(2, worid);
		ptmt.setInt(3, state);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next())
		{
			wcb=new WorkColumnBean();
			wcb.setWrk_no(rs.getInt("Wrk_no"));
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
	public int getColNo(String teaid, int worid, String state) {
		// TODO Auto-generated method stub
		String sql="select max(Col_no) from WorkColumn where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, teaid);
			pstmt.setInt(2, worid);
			pstmt.setInt(3, Integer.parseInt(state));
			//pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int vino=rs.getInt("max(Col_no)");
				return vino;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return 0;
	}

}

