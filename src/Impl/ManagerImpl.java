package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.ManagerBean;
import Dao.ManagerDao;
import Util.Util;

public class ManagerImpl implements ManagerDao {

	@Override
	public ManagerBean login(String userno, String password) {
		// TODO Auto-generated method stub
		String sql="select a.* from Manager a,roleofuser b,role c where a.Mng_no=? and a.password=? and a.Mng_no=b.User_no and b.role_no=c.role_no and c.role_no=1";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userno);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				ManagerBean mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				//mb.setIdentity(rs.getInt("identity"));
				return mb;
			}
			else{
				return null;
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
	public void addManager(ManagerBean manager) {
		// TODO Auto-generated method stub
		String sql="insert into Manager (Mng_no,Mng_name,password,email,dpmt) values (?,?,?,?,?)";//修改insert
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, manager.getMng_no());
			ptmt.setString(3, manager.getMng_no());//初始密码和用户编号相同
			ptmt.setString(2, manager.getMng_name());
			ptmt.setString(4, manager.getEmail());
			ptmt.setString(5, manager.getDpmt());
			//System.out.println("managerimpl 62:"+manager.getDpmt());
			//ptmt.setInt(3, manager.getIdentity());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public void updateManager(ManagerBean manager) {
		// TODO Auto-generated method stub
		String sql ="update Manager set dpmt=? where Mng_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			//ptmt.setString(1, manager.getMng_name());
			ptmt.setString(1,manager.getDpmt());
			ptmt.setString(2, manager.getMng_no());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

	}

	@Override
	public void delManager(String managerno) {
		// TODO Auto-generated method stub
		String sql="delete from Manager where Mng_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,managerno);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public List<ManagerBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Manager where Mng_no in(select User_no from roleofuser)";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}


	public List<ManagerBean> queryIdent(int idtfy) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Manager a,RoleOfUser b where a.Mng_no=b.User_no and b.role_no=?";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, idtfy);
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;
	}

	@Override
	public List<ManagerBean> queryno(String id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Manager where Mng_no like ? and Mng_no in(select User_no from roleofuser)";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+id+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				//mb.setIdentity(rs.getInt("identity"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

	@Override
	public List<ManagerBean> querydpmt(String dpmt) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Manager where dpmt like ? and Mng_no in(select User_no from roleofuser)";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+dpmt+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				//mb.setIdentity(rs.getInt("identity"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

	@Override
	public List<ManagerBean> queryname(String name) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Manager where Mng_name like ? and Mng_no in(select User_no from roleofuser)";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+name+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				//mb.setIdentity(rs.getInt("identity"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

	@Override
	public ManagerBean get(String id) {
		// TODO Auto-generated method stub
		String sql="select * from Manager where Mng_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				ManagerBean mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				return mb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return null;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	public List<ManagerBean> queryIdno(int idtfy, String id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Manager a,RoleOfUser b where a.Mng_no=b.User_no and b.role_no=? and a.Mng_no like ?";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, idtfy);
			ptmt.setString(2, "%"+id+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

	@Override
	public List<ManagerBean> queryIddpmt(int idtfy, String dpmt) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Manager a,RoleOfUser b where a.Mng_no=b.User_no and b.role_no=? and a.dpmt like ?";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, idtfy);
			ptmt.setString(2, "%"+dpmt+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

	@Override
	public List<ManagerBean> queryIdname(int idtfy, String name) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Manager a,RoleOfUser b where a.Mng_no=b.User_no and b.role_no=? and a.Mng_name like ?";
		List<ManagerBean> managers=new ArrayList<ManagerBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, idtfy);
			ptmt.setString(2, "%"+name+"%");
			ResultSet rs=ptmt.executeQuery();
			ManagerBean mb=null;
			while(rs.next())
			{
				mb=new ManagerBean();
				mb.setEmail(rs.getString("email"));
				mb.setMng_no(rs.getString("Mng_no"));
				mb.setMng_name(rs.getString("Mng_name"));
				mb.setPassword(rs.getString("password"));
				mb.setDpmt(rs.getString("dpmt"));
				managers.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return managers;	
	}

}
