package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.RoleBean;
import Bean.RoleOfUserBean;
import Dao.RoleOfUserDao;
import Util.Util;

public class RoleOfUserImpl implements RoleOfUserDao {

	@Override
	public void addRU(int Roleno, String Userno) {
		// TODO Auto-generated method stub
		String sql="insert into RoleOfUser (role_no,User_no) values (?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, Roleno);
			ptmt.setString(2,Userno);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public void delRU(int Roleno, String Userno) {
		// TODO Auto-generated method stub
		String sql="delete from RoleOfUser where role_no=? and User_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, Roleno);
			ptmt.setString(2,Userno);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public List<RoleOfUserBean> query() {
		// TODO Auto-generated method stub
		Util util = new Util();
		Connection conn = util.openConnection();
		String sql = "select * from RoleOfUser";
		List<RoleOfUserBean> rous = new ArrayList<RoleOfUserBean>();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			RoleOfUserBean rub = null;
			while (rs.next()) {
				rub = new RoleOfUserBean();
				rub.setUser_no(rs.getString("User_no"));
				rub.setRole_no(rs.getInt("role_no"));
				rous.add(rub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		return rous;
	}

	@Override
	public List<RoleOfUserBean> queryRno(int rno) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from RoleOfUser where role_no=?";
		List<RoleOfUserBean> rubs=new ArrayList<RoleOfUserBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, rno);
			ResultSet rs=ptmt.executeQuery();
			RoleOfUserBean rub=null;
			while(rs.next())
			{
				rub=new RoleOfUserBean();
				rub.setUser_no(rs.getString("User_no"));
				rub.setRole_no(rs.getInt("role_no"));
				rubs.add(rub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return rubs;
	}

	@Override
	public List<String> queryUserno(String uno) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select b.role_name from RoleOfUser a,Role b where a.role_no=b.role_no and a.User_no=?";
		List<String> rubs=new ArrayList<String>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, uno);
			ResultSet rs=ptmt.executeQuery();
			RoleBean rb=null;
			while(rs.next())
			{
				rb=new RoleBean();
				rb.setRole_name(rs.getString("role_name"));
				rubs.add(rb.getRole_name());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return rubs;
	}

	@Override
	public List<RoleOfUserBean> queryRU(int rno, String uno) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from RoleOfUser where role_no=? and User_no like ?";
		List<RoleOfUserBean> rubs=new ArrayList<RoleOfUserBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, rno);
			ptmt.setString(2, "%"+uno+"%");
			ResultSet rs=ptmt.executeQuery();
			RoleOfUserBean rub=null;
			while(rs.next())
			{
				rub=new RoleOfUserBean();
				rub.setUser_no(rs.getString("User_no"));
				rub.setRole_no(rs.getInt("role_no"));
				rubs.add(rub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return rubs;
	}

	@Override
	public void del(String Userno) {
		// TODO Auto-generated method stub
		String sql="delete from RoleOfUser where User_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, Userno);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

}
