package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Bean.Video_imageBean;
import Bean.WorksBean;
import Dao.Video_imageDao;
import Util.Util;
import columnXML.CreatXML;

public class Video_imageImpl implements Video_imageDao {

	@Override
	public void addvi(Video_imageBean vi) {
		// TODO Auto-generated method stub
		//int i=0;
		String sql="insert into Video_image (VI_no,video,image) values (?,?,?)";
		Util util=new Util();
		int autoIncKeyFromApi = -1;
		Connection conn=util.openConnection();
			try {
				//Statement stmt = (Statement) conn.createStatement();				
				//stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);				
				//PreparedStatement ptmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement ptmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				//ptmt.setInt(1, vi.getState());
				ptmt.setInt(1, vi.getVI_no());//初始密码和用户编号相同
				ptmt.setString(2, vi.getVideo());
				ptmt.setString(3, vi.getImage());
				ptmt.executeUpdate();  
			   /* ResultSet rs = ptmt.getGeneratedKeys();    
			    if (rs.next()) {    
			        autoIncKeyFromApi = rs.getInt(1);    
			    }       */
			      
				//i=vi.getVI_no();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
		//	return autoIncKeyFromApi;
	}

	@Override
	public void deletevi(int VI_no) {
		// TODO Auto-generated method stub
		String sql="delete from Video_image where VI_no=?";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				//ptmt.setInt(1, state);
				ptmt.setInt(1, VI_no);//初始密码和用户编号相同
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

	@Override
	public void updatevi(Video_imageBean vi,Video_imageBean vi1) {
		// TODO Auto-generated method stub
		String sql="update Video_image set video=?,image=? where VI_no=? ";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				//ptmt.setInt(3, vi.getState());
				ptmt.setInt(3, vi.getVI_no());//初始密码和用户编号相同
				ptmt.setString(1, vi1.getVideo());
				ptmt.setString(2, vi1.getImage());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}
	
	@Override
	public Video_imageBean get(int VIno) {
		// TODO Auto-generated method stub
		Video_imageBean vi=null;
		Util util=new Util();
		Connection conn=util.openConnection();
		String sql="select * from Video_image where VI_no=? ";
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				//ptmt.setInt(1, state);
				ptmt.setInt(1, VIno);//初始密码和用户编号相同
				ResultSet rs=ptmt.executeQuery();
				if(rs.next()){
					vi=new Video_imageBean();
					vi.setImage(rs.getString("image"));
					//vi.setState(rs.getInt("state"));
					vi.setVI_no(rs.getInt("VI_no"));
					vi.setVideo(rs.getString("video"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
			return vi;
	}

	@Override
	public void addimg(String url,int id) {
		// TODO Auto-generated method stub
		String sql="update Video_image set image=? where VI_no=? ";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				//ptmt.setInt(3, vi.getState());
				ptmt.setInt(2, id);//初始密码和用户编号相同
				//ptmt.setString(1, vi.getVideo());
				//String x=String.valueOf()
				ptmt.setString(1,url);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}
	
	public void addvideo(String url,int id) {
		// TODO Auto-generated method stub
		String sql="update Video_image set video=? where VI_no=? ";
		Util util=new Util();
		Connection conn=util.openConnection();
			try {
				PreparedStatement ptmt=conn.prepareStatement(sql);
				//ptmt.setInt(3, vi.getState());
				ptmt.setInt(2, id);//初始密码和用户编号相同
				//ptmt.setString(1, vi.getVideo());
				//String x=String.valueOf()
				ptmt.setString(1,url);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConnection(conn);
			}
	}

}
