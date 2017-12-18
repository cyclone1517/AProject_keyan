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
import columnXML.CreatXML;
import columnXML.delXML;

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
		if(action.equals("upXMLImg")&&ide.equals("img"))
		{
			upXMLImg(request,response);
		}
		if(action.equals("upload")&&ide.equals("video"))
		{
			uploadVideo(request,response);
		}
		if(action.equals("addcol")&&ide.equals("col"))
		{
			addcol(request,response);
		}
		if(action.equals("updatecol")&&ide.equals("col"))
		{
			updatecol(request,response);
		}
		if(action.equals("delcol")&&ide.equals("col"))
		{
			delcol(request,response);
		}
	}
	
	protected void uploadImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		Date now = new Date();  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");       
	    String childDirectory  = df.format(now);
	    String childDirectory1=childDirectory.substring(0, 7);
	    String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/files/"+childDirectory1+"/");  
	    WorksDao wsd=new WorksImpl();
	    response.addHeader("P3P", "CP=CAO PSA OUR");
	    
	    File file = new File(storeDirectoryPath);  
        if(!file.exists()){  
            file.mkdirs();  
        }  
        SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		
		su.setMaxFileSize(1024 * 1024 * 3);
		su.setAllowedFilesList("jpg,png,gif");
		try {
			su.upload();
			String ext = su.getFiles().getFile(0).getFileExt() ;    //取得文件的扩展名
			HttpSession session=request.getSession();
			int vino=Integer.parseInt(session.getAttribute("vid").toString());
			String idimg=session.getAttribute("vid").toString();
		    Video_imageDao vid=new Video_imageImpl();
		    String url=storeDirectoryPath+"*"+idimg+"*"+ext;
			///String ext = su.getFiles().getFile(0).getFileExt() ;    //鍙栧緱鏂囦欢鐨勬墿灞曞悕
			if(su.getFiles().getFile(0).isMissing()){
				response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/videoedit.jsp");
				return ;
			}
			else{
				vid.addimg(url, vino);
				su.getFiles().getFile(0).saveAs(storeDirectoryPath+idimg+"."+ext) ;
			}
		    
			//su.save(storeDirectoryPath);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("workedit/videoedit.jsp");
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/videoedit.jsp");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("上传成功"+idimg);
		//out.println("涓婁紶鎴愬姛"+idimg1);
		//request.setAttribute("viID", idimg);
		//request.getRequestDispatcher("/workedit/videoedit.jsp").forward(request, response);
	}
	
	protected void upXMLImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		Date now = new Date();  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");       
	    String childDirectory  = df.format(now);
	    String childDirectory1=childDirectory.substring(0, 7);
	    String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/XMLfiles/"+childDirectory1+"/");  
	    WorksDao wsd=new WorksImpl();
	    response.addHeader("P3P", "CP=CAO PSA OUR");
	    
	    File file = new File(storeDirectoryPath);  
        if(!file.exists()){  
            file.mkdirs();  
        }  
        SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		
		su.setMaxFileSize(1024 * 1024 * 3);
		su.setAllowedFilesList("jpg,png,gif");
		try {
			su.upload();
			String ext = su.getFiles().getFile(0).getFileExt() ;  //取得文件的扩展名
			String name=su.getFiles().getFile(0).getFieldName();
			PrintWriter out = response.getWriter();
			out.print("LoadServlet177:"+name);
		   // String url=storeDirectoryPath+"*"+idimg+"*"+ext;
			///String ext = su.getFiles().getFile(0).getFileExt() ;    //鍙栧緱鏂囦欢鐨勬墿灞曞悕
			/*if(su.getFiles().getFile(0).isMissing()){
				response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/ColContent.jsp");
				return ;
			}
			else{
				/*su.getFiles().getFile(0).saveAs(storeDirectoryPath+idimg+"."+ext) ;*/
		//	}
		    
			//su.save(storeDirectoryPath);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("workedit/videoedit.jsp");
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/videoedit.jsp");
		response.setContentType("text/html");
		
	}
	
	
	protected void uploadVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		Date now = new Date();  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");       
	    String childDirectory  = df.format(now);
	    String childDirectory1=childDirectory.substring(0, 7);
	    String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/filesVideo/"+childDirectory1+"/");  
	    File file = new File(storeDirectoryPath);  
        if(!file.exists()){  
            file.mkdirs();  
        }  
        SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setMaxFileSize(1024 * 1024 * 1024);
		su.setAllowedFilesList("avi,rmvb,rm,asf,divx,mpg,mpeg,mpe,wmv,mp4,mkv,vob");
		String result = "上传成功";
		try {
			su.upload();
			String ext = su.getFiles().getFile(0).getFileExt() ;    //取得文件的扩展名
			response.addHeader("P3P", "CP=CAO PSA OUR");
			HttpSession session=request.getSession();
			int vino=Integer.parseInt(session.getAttribute("vid").toString());
			String idimg=session.getAttribute("vid").toString();
			Video_imageDao vid=new Video_imageImpl();
			String url=storeDirectoryPath+"*"+idimg+"*"+ext;
			if(su.getFiles().getFile(0).isMissing()){
				response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
				return;
			}
			else{
				vid.addvideo(url, vino);
				su.getFiles().getFile(0).saveAs(storeDirectoryPath+idimg+"."+ext) ;
			}			
			//su.save(storeDirectoryPath);		
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("workedit/videoedit.jsp");
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
		//out.println("上传成功"+idimg);
	}
	
	protected void addcol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String wid=request.getParameter("wid");
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		String tid=request.getParameter("tid");
		String state=request.getParameter("state");
		String colname=request.getParameter("colname");
		WorkColumnBean wcb=new WorkColumnBean();
		WorkColumnDao wcd=new WorkColumnImpl();
		wcb.setWrk_no(Integer.parseInt(wid));
		wcb.setTch_no(tid);
		wcb.setState(Integer.parseInt(state));
		wcb.setCol_name(colname);
		int t=wcd.getColNo(tid,Integer.parseInt(wid),String.valueOf(state));
		int num=wcd.addcol(wcb, Integer.parseInt(state));
		new CreatXML().addColElement(tid,wid,"0",String.valueOf(num));
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("上传成功"+num+"%"+wid);
	}
	protected void updatecol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		String tid=request.getParameter("tid");
		String colno=request.getParameter("colid");
		String colname=request.getParameter("colname");
		WorkColumnBean wcb=new WorkColumnBean();
		WorkColumnDao wcd=new WorkColumnImpl();
		wcd.updatecol(tid, Integer.parseInt(wid), "0", colno, colname);
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
	}
	protected void delcol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		String tid=request.getParameter("tid");
		String state=request.getParameter("state");
		String colno=request.getParameter("colid");
		WorkColumnBean wcb=new WorkColumnBean();
		WorkColumnDao wcd=new WorkColumnImpl();
		new delXML().delColElement(tid, wid, state, colno);
		wcd.deletecol(tid, Integer.parseInt(wid), state, colno);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("上传成功"+wid+"?"+colno+"?"+state+"?");
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
	}
}
