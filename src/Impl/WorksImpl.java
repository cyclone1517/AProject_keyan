package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Bean.ManagerBean;
import Bean.TeacherBean;
import Bean.WorksBean;
import Dao.TeacherDao;
import Dao.WorksDao;
import Util.Util;
import columnXML.CreatXML;

public class WorksImpl implements WorksDao {

	@Override
	public void addwork(WorksBean work){
		// TODO Auto-generated method stub
		String sql="insert into Works (Wrk_no, Wrk_name,Tch_no,Type_ID,wlabel,intro,createTime) values (?,?,?,?,?,?,current_date())";
		Util util=new Util();
		Connection conn=util.openConnection();
		int autoIncKeyFromApi = -1;
		/*TeacherBean teacher=new TeacherBean();
		TeacherDao td=new TeacherImpl();
		teacher=td.get(work.getTch_no());
		int x=teacher.getWrkNumRcd()+1;
		String workid=Integer.toString(x);*/
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, work.getWrk_no());
				ptmt.setString(2, work.getWrk_name());//初始密码和用户编号相同
				ptmt.setString(3, work.getTch_no());
				ptmt.setString(4, work.getType_ID());
				ptmt.setString(5, work.getWlabel());
				ptmt.setString(6, work.getIntro());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
		//	String state1=String.valueOf(work.getState());
		//	new CreatXML().addWorElement(work.getTch_no(),work.getWrk_no(),state1);
	}
	@Override
	public void delwork(String Tch_no, String Wrk_no, int state) {
		String sql="delete from Works where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
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
	public void changecreTosub(String Tch_no, String Wrk_no) {
		// TODO Auto-generated method stub
		String sql="update Works set state=1 where Tch_no=? and Wrk_no=? and state=0";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

	}
	@Override
	public void changesubTopas(String Tch_no, String Wrk_no){
		String sql="update Works set state=2 where Tch_no=? and Wrk_no=? and state=1";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	@Override
	public void changepasTodel(String Tch_no, String Wrk_no){
		String sql="update Works set state=3 where Tch_no=? and Wrk_no=? and state=2";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	@Override
	public List<WorksBean> query() {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			WorksBean wb=null;
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getString(""));
				wb.setWrk_name(rs.getString(""));
				wb.setWlabel(rs.getString(""));
				wb.setVI_no(rs.getString(""));
				wb.setType_ID(rs.getString(""));
				wb.setTch_no(rs.getString(""));
				wb.setSubmitTime(rs.getDate(""));
				wb.setState(rs.getInt(""));
				wb.setIntro(rs.getString(""));
				wb.setCreateTime(rs.getDate(""));
				wb.setCheckTime(rs.getDate(""));
				wb.setCountNum(rs.getInt(""));
				works.add(wb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return works;	
	}

	@Override
	public List<WorksBean> querycreid(String Tch_no, int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works where Tch_no=? and state=?";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setInt(2,state);
			ResultSet rs=ptmt.executeQuery();
			WorksBean wb=null;
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getString(""));
				wb.setWrk_name(rs.getString(""));
				wb.setWlabel(rs.getString(""));
				wb.setVI_no(rs.getString(""));
				wb.setType_ID(rs.getString(""));
				wb.setTch_no(rs.getString(""));
				wb.setSubmitTime(rs.getDate(""));
				wb.setState(rs.getInt(""));
				wb.setIntro(rs.getString(""));
				wb.setCreateTime(rs.getDate(""));
				wb.setCheckTime(rs.getDate(""));
				wb.setCountNum(rs.getInt(""));
				works.add(wb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return works;	
	}

	@Override
	public List<WorksBean> querystate(int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works where state=?";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1,state);
			ResultSet rs=ptmt.executeQuery();
			WorksBean wb=null;
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getString(""));
				wb.setWrk_name(rs.getString(""));
				wb.setWlabel(rs.getString(""));
				wb.setVI_no(rs.getString(""));
				wb.setType_ID(rs.getString(""));
				wb.setTch_no(rs.getString(""));
				wb.setSubmitTime(rs.getDate(""));
				wb.setState(rs.getInt(""));
				wb.setIntro(rs.getString(""));
				wb.setCreateTime(rs.getDate(""));
				wb.setCheckTime(rs.getDate(""));
				wb.setCountNum(rs.getInt(""));
				works.add(wb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return works;
	}

	@Override
	public List<WorksBean> queryalworkid(String Wrk_no) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works where state=2 and Wrk_no=?";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Wrk_no);
			ResultSet rs=ptmt.executeQuery();
			WorksBean wb=null;
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getString("Wrk_no"));
				wb.setWrk_name(rs.getString("Wrk_name"));
				wb.setWlabel(rs.getString("wlabel"));
				wb.setVI_no(rs.getString("VI_no"));
				wb.setType_ID(rs.getString("Type_ID"));
				wb.setTch_no(rs.getString("Tch_no"));
				wb.setSubmitTime(rs.getDate("submitTime"));
				wb.setState(rs.getInt("state"));
				wb.setIntro(rs.getString("intro"));
				wb.setCreateTime(rs.getDate("createTime"));
				wb.setCheckTime(rs.getDate("checkTime"));
				wb.setCountNum(rs.getInt("countNum"));
				works.add(wb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		return works;
	}

	@Override
	public List<WorksBean> query(String Type_name, Date startTime, Date endTime, String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querycli(String Type_name, Date startTime, Date endTime, String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytype(String Type_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytypecli(String Type_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytime(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytimecli(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querylabel(String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querylabelcli(String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytytime(String Type_name, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytytimecli(String Type_name, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytylab(String Type_name, String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querytylabcli(String Type_name, String wlabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querylabtime(String wlabel, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorksBean> querylabtimecli(String wlabel, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorksBean get(String Tch_no, String Wrk_no, int state) {
		// TODO Auto-generated method stub
		String sql="select * from Works where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setString(2,Wrk_no);
			ptmt.setInt(3,state);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				WorksBean wb=new WorksBean();
				wb.setWrk_no(rs.getString("Wrk_no"));
				wb.setWrk_name(rs.getString("Wrk_name"));
				wb.setWlabel(rs.getString("wlabel"));
				wb.setVI_no(rs.getString("VI_no"));
				wb.setType_ID(rs.getString("Type_ID"));
				wb.setTch_no(rs.getString("Tch_no"));
				wb.setSubmitTime(rs.getDate("submitTime"));
				wb.setState(rs.getInt("state"));
				wb.setIntro(rs.getString("intro"));
				wb.setCreateTime(rs.getDate("createTime"));
				wb.setCheckTime(rs.getDate("checkTime"));
				wb.setCountNum(rs.getInt("countNum"));
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
	public int getvi_id() {
		// TODO Auto-generated method stub
		String sql="select max(VI_no) from Works";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int vino=rs.getInt("max(VI_no)");
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
