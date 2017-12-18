package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.TeacherBean;
import Bean.WorkTpeBean;
import Dao.WorkTpeDao;
import Util.Util;

public class WorkTpeImpl implements WorkTpeDao {

	@Override
	public void addworktpe(WorkTpeBean worktype) {
		// TODO Auto-generated method stub
		String sql="insert into WorkTpe (Type_ID,Type_name) values (?,?)";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, worktype.getType_ID());
				ptmt.setString(2, worktype.getType_name());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	@Override
	public void delworktpe(String Type_ID) {
		// TODO Auto-generated method stub
		String sql="delete from WorkTpe where Type_ID=?";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, Type_ID);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	@Override
	public void updateworktpe(String Type_ID,String Type_name) {
		// TODO Auto-generated method stub
		String sql="update WorkTpe set Type_name=? where Type_ID=?";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, Type_ID);
				ptmt.setString(2, Type_name);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	@Override
	public List<WorkTpeBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from WorkTpe";
		List<WorkTpeBean> wtbs=new ArrayList<WorkTpeBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			
			WorkTpeBean wtb=null;
			while(rs.next())
			{
				wtb=new WorkTpeBean();
				wtb.setType_ID(rs.getString("Type_ID"));
				wtb.setType_name(rs.getString("Type_name"));
				wtbs.add(wtb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return wtbs;	
	}

}
