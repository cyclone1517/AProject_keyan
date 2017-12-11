package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import Bean.Video_imageBean;
import Bean.WorkColumnBean;
import Bean.WorksBean;
import Dao.Video_imageDao;
import Dao.WorkColumnDao;
import Dao.WorksDao;
import Impl.Video_imageImpl;
import Impl.WorkColumnImpl;
import Impl.WorksImpl;

/**
 * Servlet implementation class loadServlet
 */
@WebServlet("/loadServlet")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		String action=request.getParameter("action");
		String ide=request.getParameter("ide");
		if(action.equals("upload")&&ide.equals("img"))
		{
			uploadImg(request,response);
		}
		if(action.equals("upload")&&ide.equals("video"))
		{
			uploadVideo(request,response);
		}
		if(action.equals("addcol")&&ide.equals("col"))
		{
			addcol(request,response);
		}
	}
	
	protected void uploadImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//从request中获取六信息
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		Date now = new Date();  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");       
	    String childDirectory  = df.format(now);
	    String childDirectory1=childDirectory.substring(0, 7);
	    String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/files/"+childDirectory1+"/");  
	    WorksDao wsd=new WorksImpl();
		int vino=wsd.getvi_id();
	   // Video_imageBean vi=new Video_imageBean(); 
	    Video_imageDao vid=new Video_imageImpl();
	    HttpSession session=request.getSession();
	   // String idimg1=session.getAttribute("vino").toString();
	    String idimg=String.valueOf(vino);
	    String url=storeDirectoryPath+"*"+idimg;
	    //int id1=Integer.getInteger(idimg);
	    vid.addimg(url, vino);
	    //vid.addimg(url, 3);
	    File file = new File(storeDirectoryPath);  
        if(!file.exists()){  
            file.mkdirs();  
        }  
        SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		// 设置最大文件大小
		su.setMaxFileSize(1024 * 1024 * 3);
		su.setAllowedFilesList("jpg,png,gif");
		String result = "上传成功";
		try {
			su.upload();
			String ext = su.getFiles().getFile(0).getFileExt() ;    //取得文件的扩展名
			su.getFiles().getFile(0).saveAs(storeDirectoryPath+idimg+"."+ext) ;
			//su.save(storeDirectoryPath);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			result = "上传失败";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("workedit/videoedit.jsp");
		//response.sendRedirect("workedit/videoedit.jsp");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("上传成功"+idimg1);
		//request.setAttribute("viID", idimg);
		//request.getRequestDispatcher("/workedit/videoedit.jsp").forward(request, response);
	}
	
	protected void uploadVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//从request中获取六信息
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		Date now = new Date();  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");       
	    String childDirectory  = df.format(now);
	    String childDirectory1=childDirectory.substring(0, 7);
	    String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/filesVideo/"+childDirectory1+"/");  
	    HttpSession session=request.getSession();
	    String idvd=session.getAttribute("vino").toString();
	    Video_imageDao vid=new Video_imageImpl();
	    String url=storeDirectoryPath+"*"+idvd;
	    int id1=Integer.parseInt(idvd);
	    vid.addvideo(url, id1);
	    File file = new File(storeDirectoryPath);  
        if(!file.exists()){  
            file.mkdirs();  
        }  
        SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		// 设置最大文件大小
		su.setMaxFileSize(1024 * 1024 * 1024);
		su.setAllowedFilesList("avi,rmvb,rm,asf,divx,mpg,mpeg,mpe,wmv,mp4,mkv,vob");
		String result = "上传成功";
		try {
			su.upload();
			String ext = su.getFiles().getFile(0).getFileExt() ;    //取得文件的扩展名
			//String name = su.getRequest().getParameter("name") ;//通过SmartUpload取得name参数的值
			su.getFiles().getFile(0).saveAs(storeDirectoryPath+idvd+"."+ext) ;
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			result = "上传失败";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/workedit/coledit.jsp").forward(request, response);		
	}
	
	protected void addcol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String wid=request.getParameter("wid");
		String tid=request.getParameter("tid");
		String state=request.getParameter("state");
		String colname=request.getParameter("colname");
		WorkColumnBean wcb=new WorkColumnBean();
		WorkColumnDao wcd=new WorkColumnImpl();
		wcb.setWrk_no(wid);
		wcb.setTch_no(tid);
		wcb.setState(Integer.parseInt(state));
		wcb.setCol_name(colname);
		wcd.addcol(wcb, Integer.parseInt(state));
		response.sendRedirect("workedit/coledit.jsp");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("上传成功"+colname);
	}
}
