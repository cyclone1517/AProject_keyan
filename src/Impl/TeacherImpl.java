package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Bean.TeacherBean;
import Dao.TeacherDao;
import Util.Util;

public class TeacherImpl implements TeacherDao {

	@Override
	public TeacherBean login(String userno, String password) {
		// TODO Auto-generated method stub
		String sql="select a.* from Teacher a,roleofuser b,role c where a.Tch_no=? and a.password=? and a.Tch_no=b.User_no and b.role_no=c.role_no and c.role_no=2 ";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userno);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				TeacherBean tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				return tb;
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
	public void addTeacher(TeacherBean teacher){
		// TODO Auto-generated method stub
		String sql="insert into Teacher(Tch_no,Tch_name,password,dpmt,email,title) values (?,?,?,?,?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, teacher.getTch_no());
			ptmt.setString(3, teacher.getTch_no());
			ptmt.setString(2, teacher.getTch_name());
			ptmt.setString(4, teacher.getDpmt());
			ptmt.setString(5, teacher.getEmail());
			ptmt.setString(6, teacher.getTitle());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	

	@Override
	public void updateTeacher(TeacherBean teacher) {
		// TODO Auto-generated method stub
		String sql ="update Teacher set title=?,dpmt=? where Tch_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, teacher.getTitle());
			ptmt.setString(2,teacher.getDpmt());
			ptmt.setString(3, teacher.getTch_no());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		

	}

	@Override
	public void delTeac(String teacherno) {
		// TODO Auto-generated method stub
		String sql="delete from Teacher where Tch_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,teacherno);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public List<TeacherBean> query(int id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Teacher a,roleofuser b where a.Tch_no=b.User_no and b.role_no=? ";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}
	
	public List<TeacherBean> query1(int id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select t.* from Teacher t,roleofuser r where t.Tch_no not in (select b.Tch_no from Manager a,Teacher b where a.Mng_no=b.Tch_no) and t.Tch_no=r.User_no and r.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}
	
	@Override
	public List<TeacherBean> queryId(int no,String id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Teacher a,roleofuser b where a.Tch_no=b.User_no and b.role_no=? and a.Tch_no like ?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, no);
			ptmt.setString(2, "%"+id+"%");
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}

	public List<TeacherBean> queryId1(int no,String id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select t.* from Teacher t,roleofuser r where t.Tch_no not in (select b.Tch_no from Manager a,Teacher b where a.Mng_no=b.Tch_no) and t.Tch_no like ? and t.Tch_no=r.User_no and r.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+id+"%");
			ptmt.setInt(2, no);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}
	
	@Override
	public List<TeacherBean> queryDpmt(int no,String dpmt) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Teacher a,roleofuser b where a.dpmt like ? and a.Tch_no=b.User_no and b.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+dpmt+"%");
			ptmt.setInt(2, no);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}

	public List<TeacherBean> queryDpmt1(int no,String dpmt) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select t.* from Teacher t,roleofuser r where t.Tch_no not in (select b.Tch_no from Manager a,Teacher b where a.Mng_no=b.Tch_no) and t.dpmt like ? and t.Tch_no=r.User_no and r.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+dpmt+"%");
			ptmt.setInt(2, no);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;	
	}
	
	@Override
	public List<TeacherBean> queryName(int no,String name) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select a.* from Teacher a,roleofuser b where a.Tch_name like ? and a.Tch_no=b.User_no and b.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+name+"%");
			ptmt.setInt(2, no);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;
	}
	
	public List<TeacherBean> queryName1(int no,String name) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select t.* from Teacher t,roleofuser r where t.Tch_no not in (select b.Tch_no from Manager a,Teacher b where a.Mng_no=b.Tch_no) and t.Tch_name like ? and t.Tch_no=r.User_no and r.role_no=?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+name+"%");
			ptmt.setInt(2, no);
			ResultSet rs=ptmt.executeQuery();
			TeacherBean tb=null;
			while(rs.next())
			{
				tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				teachers.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return teachers;
	}
	
	public TeacherBean get(String id) {
		// TODO Auto-generated method stub
		String sql="select * from teacher where Tch_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				TeacherBean tb=new TeacherBean();
				tb.setDpmt(rs.getString("dpmt"));
				tb.setEmail(rs.getString("email"));
				tb.setPassword(rs.getString("password"));
				tb.setTch_name(rs.getString("Tch_name"));
				tb.setTch_no(rs.getString("Tch_no"));
				tb.setTitle(rs.getString("title"));
				tb.setWrkNum(rs.getInt("wrkNum"));
				tb.setWrkNumRcd(rs.getInt("wrkNumRcd"));
				return tb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return null;
	}

}
