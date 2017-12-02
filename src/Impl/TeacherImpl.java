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
		String sql="select * from Teacher where Tch_no=? and password=?";
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
		String sql="insert into Teacher(Tch_no,password) values (?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, teacher.getTch_no());
			ptmt.setString(2, teacher.getTch_no());
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
		String sql ="update Teacher set title=?,dpmp=? where Tch_no=?";
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
	public List<TeacherBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Teacher";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
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
	public List<TeacherBean> queryId(String id) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Teacher where Tch_no like ?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+id+"%");
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
	public List<TeacherBean> queryDpmt(String dpmt) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Teacher where dpmt like ?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+dpmt+"%");
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
	public List<TeacherBean> queryName(String name) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Teacher where Tch_name like ?";
		List<TeacherBean> teachers=new ArrayList<TeacherBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, "%"+name+"%");
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
				String name=rs.getString(2);
				TeacherBean bean=new TeacherBean();
				bean.setTch_name(name);
				return bean;
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
