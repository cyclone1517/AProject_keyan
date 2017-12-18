package Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		String sql="insert into Works (Wrk_name,Tch_no,state,Type_ID,wlabel,intro,createTime,VI_no) values (?,?,?,?,?,?,current_date())";
		Util util=new Util();
		Connection conn=util.openConnection();
		int autoIncKeyFromApi = -1;
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setInt(1, work.getWrk_no());
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
			String state1=String.valueOf(work.getState());
			new CreatXML().addWorElement(work.getTch_no(),String.valueOf(work.getWrk_no()),state1);
	}
	
	@Override
	public int addnewWork(String tid, int state) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		int t=0;
		try {
			System.out.println("workimpl 57:"+tid+" "+state);
			CallableStatement cst=conn.prepareCall("{call addnewWork(?,?,?)}");
			cst.setString(1, tid);
			cst.setInt(2, state);
			cst.registerOutParameter(3,  java.sql.Types.INTEGER); 
			cst.execute();
			t=cst.getInt(3);
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		//StringUtils.substringBeforeLast(str, separator)
		//new CreatXML().addWorElement(tid,String.valueOf(t),String.valueOf(state));
		return t;
	}
	
	@Override
	public int getmaxWid(String tid, int state) {
		// TODO Auto-generated method stub
		String sql="select max(Wrk_no) from Works where Tch_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tid);
			pstmt.setInt(2, state);
			//pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int vino=rs.getInt("max(Wrk_no)");
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
	
	@Override
	public void delwork(String Tch_no, int Wrk_no, int state) {
		String sql="delete from Works where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setInt(2,Wrk_no);
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
	public void changecreTosub(WorksBean work1, WorksBean work2) {
		// TODO Auto-generated method stub
		String sql="update Works set Wrk_name=?,Type_ID=?,wlabel=?,intro=?,createTime=?,VI_no=? where Wrk_no=? and Tch_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,work1.getWrk_name());
			ptmt.setString(2,work1.getType_ID());
			ptmt.setString(3, work1.getWlabel());
			ptmt.setString(4, work1.getIntro());
			ptmt.setDate(5, (java.sql.Date) work1.getCheckTime());
			ptmt.setInt(6, work1.getVI_no());
			System.out.println("worksimpl 134:"+ work2.getWrk_no());
			ptmt.setInt(7, work2.getWrk_no());
			//System.out.println("worksimpl 134:");
			ptmt.setString(8, work2.getTch_no());
			ptmt.setInt(9, work2.getState());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}

	}
	@Override
	public void changesubTopas(String Tch_no, int Wrk_no){
		String sql="update Works set state=2 where Tch_no=? and Wrk_no=? and state=1";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setInt(2,Wrk_no);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	@Override
	public void changepasTodel(String Tch_no, int Wrk_no){
		String sql="update Works set state=3 where Tch_no=? and Wrk_no=? and state=2";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setInt(2,Wrk_no);
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
				wb.setWrk_no(rs.getInt(""));
				wb.setWrk_name(rs.getString(""));
				wb.setWlabel(rs.getString(""));
				wb.setVI_no(rs.getInt(""));
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
	public List<WorksBean> querycreid(String Tch, int stat) {
		// TODO Auto-generated method stub
		WorksBean wb=null;
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works where Tch_no=? and state=?";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch);
			ptmt.setInt(2,stat);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getInt("Wrk_no"));
				wb.setWrk_name(rs.getString("Wrk_name"));
				wb.setWlabel(rs.getString("wlabel"));
				wb.setVI_no(rs.getInt("VI_no"));
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
				wb.setWrk_no(rs.getInt(""));
				wb.setWrk_name(rs.getString(""));
				wb.setWlabel(rs.getString(""));
				wb.setVI_no(rs.getInt(""));
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
	public List<WorksBean> queryalworkid(int Wrk_no) {
		// TODO Auto-generated method stub
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Works where state=2 and Wrk_no=?";
		List<WorksBean> works=new ArrayList<WorksBean>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1,Wrk_no);
			ResultSet rs=ptmt.executeQuery();
			WorksBean wb=null;
			while(rs.next())
			{
				wb=new WorksBean();
				wb.setWrk_no(rs.getInt("Wrk_no"));
				wb.setWrk_name(rs.getString("Wrk_name"));
				wb.setWlabel(rs.getString("wlabel"));
				wb.setVI_no(rs.getInt("VI_no"));
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
	public WorksBean get(String Tch_no, int Wrk_no, int state) {
		// TODO Auto-generated method stub
		String sql="select * from Works where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1,Tch_no);
			ptmt.setInt(2,Wrk_no);
			ptmt.setInt(3,state);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				WorksBean wb=new WorksBean();
				wb.setWrk_no(rs.getInt("Wrk_no"));
				wb.setWrk_name(rs.getString("Wrk_name"));
				wb.setWlabel(rs.getString("wlabel"));
				wb.setVI_no(rs.getInt("VI_no"));
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

	@Override
	public void updatework(String Tch_no, int Wrk_no, int state, String wname, String wlabel, String type,
			String intro) {
		// TODO Auto-generated method stub
		String sql="update Works set Wrk_name=?,wlabel=?,Type_ID=?,intro=? where Tch_no=? and Wrk_no=? and state=?";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ptmt.setString(1, wname);
				ptmt.setString(2, wlabel);
				ptmt.setString(3,type );
				ptmt.setString(4, intro);
				ptmt.setString(5, Tch_no);
				ptmt.setInt(6, Wrk_no);
				ptmt.setInt(7,state);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	
	



}
