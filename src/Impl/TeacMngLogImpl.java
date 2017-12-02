package Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.TeacMngLogBean;
import Dao.TeacMngLogDao;
import Util.Util;

public class TeacMngLogImpl implements TeacMngLogDao {

	@Override
	public void addTMLog(TeacMngLogBean TMLB) {
		// TODO Auto-generated method stub
		String sql="insert into TeacMngLog (Tch_no,Mng_no,operTime,oper_no) values (?,?,?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, TMLB.getTch_no());
			ptmt.setString(2, TMLB.getMng_no());
			ptmt.setDate(3, new Date(TMLB.getOperTime().getTime()));		
			ptmt.setInt(4,TMLB.getOper_no());
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public void delTMLog(String Tch_no, String Mng_no, Date operTime) {
		// TODO Auto-generated method stub
		String sql="delete from TeacMngLog where Mng_no=? and Tch_no=? and operTime=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, Mng_no);
			ptmt.setString(2, Tch_no);
			ptmt.setDate(3, operTime);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public void updateTLog(TeacMngLogBean TMLB) {
		// TODO Auto-generated method stub
		String sql ="update TeacMngLog set oper_no=? where Mng_no=? and Tch_no=? and operTime=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, TMLB.getOper_no());
			ptmt.setString(2,TMLB.getMng_no());
			ptmt.setString(3, TMLB.getTch_no());
			ptmt.setDate(4,new Date(TMLB.getOperTime().getTime()));
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public List<TeacMngLogBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from TeacMngLog";
		List<TeacMngLogBean> tmlbs=new ArrayList<TeacMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			TeacMngLogBean tmlb=null;
			while(rs.next())
			{
				tmlb=new TeacMngLogBean();
				tmlb.setMng_no(rs.getString("Mng_no"));
				tmlb.setOper_no(rs.getInt("oper_no"));
				tmlb.setOperTime(rs.getDate("operTime"));
				tmlb.setTch_no(rs.getString("Tch_no"));
				tmlbs.add(tmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return tmlbs;	
	}

	@Override
	public List<TeacMngLogBean> queryMno(String Mid) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from TeacMngLog where Mng_no like ?";
		List<TeacMngLogBean> tmlbs=new ArrayList<TeacMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);			
			ptmt.setString(1, "%"+Mid+"%");
			ResultSet rs=ptmt.executeQuery();
			TeacMngLogBean tmlb=null;
			while(rs.next())
			{
				tmlb=new TeacMngLogBean();
				tmlb.setMng_no(rs.getString("Mng_no"));
				tmlb.setOper_no(rs.getInt("oper_no"));
				tmlb.setOperTime(rs.getDate("operTime"));
				tmlb.setTch_no(rs.getString("Tch_no"));
				tmlbs.add(tmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return tmlbs;	
	}

	@Override
	public List<TeacMngLogBean> queryTno(String Tid) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from TeacMngLog where Tch_no like ?";
		List<TeacMngLogBean> tmlbs=new ArrayList<TeacMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);			
			ptmt.setString(1, "%"+Tid+"%");
			ResultSet rs=ptmt.executeQuery();
			TeacMngLogBean tmlb=null;
			while(rs.next())
			{
				tmlb=new TeacMngLogBean();
				tmlb.setMng_no(rs.getString("Mng_no"));
				tmlb.setOper_no(rs.getInt("oper_no"));
				tmlb.setOperTime(rs.getDate("operTime"));
				tmlb.setTch_no(rs.getString("Tch_no"));
				tmlbs.add(tmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return tmlbs;
	}

	@Override
	public List<TeacMngLogBean> queryOt(Date operTime1, Date operTime2) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from TeacMngLog where operTime between ? and ?";
		List<TeacMngLogBean> tmlbs=new ArrayList<TeacMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			ptmt.setDate(1, operTime1);
			ptmt.setDate(2, operTime2);
			TeacMngLogBean tmlb=null;
			while(rs.next())
			{
				tmlb=new TeacMngLogBean();
				tmlb.setMng_no(rs.getString("Mng_no"));
				tmlb.setOper_no(rs.getInt("oper_no"));
				tmlb.setOperTime(rs.getDate("operTime"));
				tmlb.setTch_no(rs.getString("Tch_no"));
				tmlbs.add(tmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return tmlbs;	
	}

	@Override
	public List<TeacMngLogBean> queryOn(int oper_no) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from TeacMngLog where oper_no=?";
		List<TeacMngLogBean> tmlbs=new ArrayList<TeacMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);			
			ptmt.setInt(1, oper_no);
			ResultSet rs=ptmt.executeQuery();
			TeacMngLogBean tmlb=null;
			while(rs.next())
			{
				tmlb=new TeacMngLogBean();
				tmlb.setMng_no(rs.getString("Mng_no"));
				tmlb.setOper_no(rs.getInt("oper_no"));
				tmlb.setOperTime(rs.getDate("operTime"));
				tmlb.setTch_no(rs.getString("Tch_no"));
				tmlbs.add(tmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return tmlbs;
	}

}
