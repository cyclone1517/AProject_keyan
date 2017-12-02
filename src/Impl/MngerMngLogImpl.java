package Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.MngerMngLogBean;
import Dao.MngerMngLogDao;
import Util.Util;

public class MngerMngLogImpl implements MngerMngLogDao {

	@Override
	public void addMMLog(MngerMngLogBean MMLB) {
		// TODO Auto-generated method stub
		String sql="insert into MngerMngLog (Mng_no,Sys_Mng_no,operTime,oper_no) values (?,?,?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, MMLB.getMng_no());
			ptmt.setString(2, MMLB.getSys_Mng_no());
			ptmt.setDate(3, new Date(MMLB.getOperTime().getTime()));	
			ptmt.setInt(4, MMLB.getOper_no());
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

	}

	@Override
	public void delMMLog(String Sys_Mng_no, String Mng_no, Date operTime) {
		// TODO Auto-generated method stub
		String sql="delete from MngerMngLog where Mng_no=? and Sys_Mng_no=? and operTime=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, Mng_no);
			ptmt.setString(2, Sys_Mng_no);		
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
	public List<MngerMngLogBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from MngerMngLog";
		List<MngerMngLogBean> mmlbs=new ArrayList<MngerMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			MngerMngLogBean mmlb=null;
			while(rs.next())
			{
				mmlb=new MngerMngLogBean();
				mmlb.setMng_no(rs.getString("Mng_no"));
				mmlb.setOper_no(rs.getInt("oper_no"));
				mmlb.setOperTime(rs.getDate("operTime"));
				mmlb.setSys_Mng_no(rs.getString("Sys_Mng_no"));;
				mmlbs.add(mmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return mmlbs;	
	}

	@Override
	public List<MngerMngLogBean> queryMno(String Mid) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from MngerMngLog where Mng_no like ?";
		List<MngerMngLogBean> mmlbs=new ArrayList<MngerMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+Mid+"%");
			ResultSet rs=ptmt.executeQuery();
			MngerMngLogBean mmlb=null;
			while(rs.next())
			{
				mmlb=new MngerMngLogBean();
				mmlb.setMng_no(rs.getString("Mng_no"));
				mmlb.setOper_no(rs.getInt("oper_no"));
				mmlb.setOperTime(rs.getDate("operTime"));
				mmlb.setSys_Mng_no(rs.getString("Sys_Mng_no"));;
				mmlbs.add(mmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return mmlbs;	
	}

	@Override
	public List<MngerMngLogBean> querySno(String Sid) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from MngerMngLog where Sys_Mng_no like ?";
		List<MngerMngLogBean> mmlbs=new ArrayList<MngerMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			ptmt.setString(1, "%"+Sid+"%");
			MngerMngLogBean mmlb=null;
			while(rs.next())
			{
				mmlb=new MngerMngLogBean();
				mmlb.setMng_no(rs.getString("Mng_no"));
				mmlb.setOper_no(rs.getInt("oper_no"));
				mmlb.setOperTime(rs.getDate("operTime"));
				mmlb.setSys_Mng_no(rs.getString("Sys_Mng_no"));;
				mmlbs.add(mmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return mmlbs;	
	}

	@Override
	public List<MngerMngLogBean> queryOt(Date operTime1,Date operTime2) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from MngerMngLog where operTime between ? and ?";
		List<MngerMngLogBean> mmlbs=new ArrayList<MngerMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			ptmt.setDate(1, operTime1);
			ptmt.setDate(2, operTime2);
			MngerMngLogBean mmlb=null;
			while(rs.next())
			{
				mmlb=new MngerMngLogBean();
				mmlb.setMng_no(rs.getString("Mng_no"));
				mmlb.setOper_no(rs.getInt("oper_no"));
				mmlb.setOperTime(rs.getDate("operTime"));
				mmlb.setSys_Mng_no(rs.getString("Sys_Mng_no"));;
				mmlbs.add(mmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return mmlbs;	
	}

	@Override
	public List<MngerMngLogBean> queryOn(int oper_no) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from MngerMngLog where oper_no=?";
		List<MngerMngLogBean> mmlbs=new ArrayList<MngerMngLogBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			ptmt.setInt(1, oper_no);
			MngerMngLogBean mmlb=null;
			while(rs.next())
			{
				mmlb=new MngerMngLogBean();
				mmlb.setMng_no(rs.getString("Mng_no"));
				mmlb.setOper_no(rs.getInt("oper_no"));
				mmlb.setOperTime(rs.getDate("operTime"));
				mmlb.setSys_Mng_no(rs.getString("Sys_Mng_no"));;
				mmlbs.add(mmlb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return mmlbs;	
	}

	@Override
	public void updateMLog(MngerMngLogBean MMLB) {
		// TODO Auto-generated method stub
		String sql ="update MngerMngLog set oper_no=? where Mng_no=? and Sys_Mng_no=? and operTime=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, MMLB.getOper_no());
			ptmt.setString(2,MMLB.getMng_no());
			ptmt.setString(3, MMLB.getSys_Mng_no());
			ptmt.setDate(4,new Date(MMLB.getOperTime().getTime()));
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

}
