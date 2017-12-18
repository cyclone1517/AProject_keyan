package Dao;

import Bean.Video_imageBean;

public interface Video_imageDao {
	public void addvi(Video_imageBean vi);
	public void addimg(String url,int id);
	public void addvideo(String url,int id);
	public void deletevi(int VI_no);
	public void updatevi(Video_imageBean vi,Video_imageBean vi1);
	public Video_imageBean get(int VIno);
	
}
