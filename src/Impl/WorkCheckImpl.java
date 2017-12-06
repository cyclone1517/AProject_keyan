package Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Bean.WorkCheckBean;
import Dao.WorkCheckDao;
import Util.Util;

public class WorkCheckImpl implements WorkCheckDao {

	@Override
	public void addwork(WorkCheckBean work) {
		// TODO Auto-generated method stub
		String sql="insert into WorkCheck (Wrk_no,Tch_no,state,Mng_no,operTime,oper_no) values (?,?,?,?,current_date(),?)";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, work.getWrk_no());
				ptmt.setString(2, work.getTch_no());
				ptmt.setInt(3, work.getState());
				ptmt.setString(4, work.getMng_no());
				ptmt.setInt(5, work.getOper_no());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	@Override
	public void delwork(String Tch_no,String Wrk_no,int state,String Mng_no,Date operTime) {
		// TODO Auto-generated method stub
		String sql="delete from WorkCheck where Tch_no=? and Wrk_no=? and state=? and Mng_no=? and operTime=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
			ptmt.setInt(3,state);
			ptmt.setString(4,Mng_no );
			ptmt.setDate(5, operTime);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

	}

	@Override
	public List<WorkCheckBean> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkCheckBean> query(String Tch_no, String Wrk_no, int state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkCheckBean> query(Date operTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkCheckBean> query(String Mng_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkCheckBean get(int oper_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkCheckBean get(String Tch_no, String Wrk_no, int state, String Mng_no, Date operTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
