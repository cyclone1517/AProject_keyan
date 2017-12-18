package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Video_imageBean;
import Bean.WorksBean;
import Bean.WorkColumnBean;
import Dao.Video_imageDao;
import Dao.WorkColumnDao;
import Dao.WorksDao;
import Impl.Video_imageImpl;
import Impl.WorkColumnImpl;
import Impl.WorksImpl;
import columnXML.CreatXML;
import columnXML.delXML;
import columnXML.parserXML;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/WorkServlet")
public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
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
		if(action.equals("upsavework")&&ide.equals("work"))
		{
			upsavework(request,response);
		}
		if(action.equals("addnewwork")&&ide.equals("work"))
		{
			addnewwork(request,response);
		}
		if(action.equals("updatework")&&ide.equals("work"))
		{
			updatework(request,response);
		}
		if(action.equals("getwid")&&ide.equals("work"))
		{
			getwid(request,response);
		}
		if(action.equals("addctent")&&ide.equals("col"))
		{
			addcontent(request,response);
		}
		if(action.equals("deleteall")&&ide.equals("all"))
		{
			deleteall(request,response);
		}
		if(action.equals("saveall")&&ide.equals("all"))
		{
			saveall(request,response);
		}
		if(action.equals("upall")&&ide.equals("all"))
		{
			upall(request,response);
		}
	}
	
	protected void upsavework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��ȡ���гɹ�
		String tid=request.getParameter("tid");
		String alwid=request.getParameter("alwid");
		String state1=request.getParameter("stat");
		int state=Integer.parseInt(state1);
		WorksDao wsd=new WorksImpl();
		WorksBean alwb=new WorksBean();
		//��ȡ�ѱ���ɹ�
		alwb=wsd.get(tid, Integer.parseInt(alwid), state);
		int alvid=alwb.getVI_no();
		//�½��ɹ�����ƵͼƬ
		int wid=wsd.addnewWork(tid, 0);
		wsd.updatework(tid, wid, 0, alwb.getWrk_name(), alwb.getWlabel(), alwb.getType_ID(), alwb.getIntro());
		new CreatXML().addWorElement(tid,String.valueOf(wid),"0");
		WorksBean wb=new WorksBean();
		//��ȡ�½��ĳɹ�
		wb=wsd.get(tid, wid, 0);
		//��ȡ�½��ɹ���vi���
		int vino=wb.getVI_no();
		//������ƵͼƬ����
		Video_imageBean vib=new Video_imageBean();
		Video_imageBean vib1=new Video_imageBean();
		Video_imageDao vd=new Video_imageImpl();
		vib.setVI_no(vino);
		vd.addvi(vib);
		vib=vd.get(vino);
		vib1=vd.get(alvid);
		//���ѱ�������ݴ浽�½���
		vd.updatevi(vib, vib1);
		//���ѱ����е���Ŀ��Ϣ���浽�½���
		String content=null;
		List<WorkColumnBean>wcbs=new ArrayList<WorkColumnBean>();
		WorkColumnDao wcd=new WorkColumnImpl();
		wcbs=wcd.queryTC(tid, Integer.parseInt(alwid), state);
		//PrintWriter out = response.getWriter();
		//out.println("�ϴ��ɹ�"+wcbs.size()+"*"+alwid);
		for(int i=0;i<wcbs.size();i++){
			WorkColumnBean wcb=wcbs.get(i);
			content=new parserXML().getColContent(tid, alwid, String.valueOf(alwb.getState()), String.valueOf(wcb.getCol_no()));
		//	PrintWriter out1 = response.getWriter();
			//out.println("�ϴ��ɹ�"+tid+"%"+alwid+"%"+wid+"%"+content);
			WorkColumnBean newwcb=new WorkColumnBean();
			newwcb.setWrk_no(wid);
			//int newcol=wcd.addcol(newwcb, 0);
			new CreatXML().addColElement(tid, String.valueOf(wid), "0", String.valueOf(wcb.getCol_no()));
			new CreatXML().addColContent(tid, String.valueOf(wid), "0", String.valueOf(wcb.getCol_no()), content);
			wcd.changeCol(newwcb, wcb);
		}
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		session.setAttribute("tid", tid);
		session.setAttribute("alwid", alwid);
		session.setAttribute("wid", wid);
		session.setAttribute("vid", vino);
		session.setAttribute("alvid", alvid);
		session.setAttribute("alstate",alwb.getState());
		//��xml�ļ�������´�������Ŀ
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/addwork.jsp");
		 return; 
		//�����гɹ���ֵ����ѡ�����
		//�����棬ɾ�����Ѵ����ĳɹ������½��ɹ���Ϊ����ɹ�
		//���ύ��ɾ�����Ѵ����ĳɹ������½��ɹ���Ϊ�ύ�ɹ�
		//�����أ�ɾ���´����ĳɹ�������ԭ���ĳɹ�
	}
	
	protected void addnewwork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tid=request.getParameter("tid");
		String state=request.getParameter("state");
		WorksImpl wd=new WorksImpl();
		int wrno=wd.addnewWork(tid, Integer.parseInt(state));
		WorksDao wsd=new WorksImpl();
		int vino=wsd.getvi_id();
		//����vi����
		Video_imageBean vib=new Video_imageBean();
		Video_imageDao vd=new Video_imageImpl();
		vib.setVI_no(vino);
		vd.addvi(vib);
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		request.setAttribute("wid", wrno);
		session.setAttribute("wid", wrno);
		session.setAttribute("tid", tid);
		session.setAttribute("vid", vino);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("�ϴ��ɹ�"+String.valueOf(wrno));
		new CreatXML().addWorElement(tid,String.valueOf(wrno),String.valueOf(state));
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/addwork.jsp");
	}
	
	protected void updatework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String workname=request.getParameter("wname");
		String wlabel=request.getParameter("wlabel");
		String type=request.getParameter("type");
		String intro=request.getParameter("intro");
		String tid=request.getParameter("tid");
	//	String wid=request.getParameter("wno");
		//String wid=request.getAttribute("wid").toString();
		//String wid=request.getParameter("wid");
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		int wrid=Integer.parseInt(wid);
		WorksDao wd=new WorksImpl();
		wd.updatework(tid, wrid, 0, workname, wlabel, type, intro);
		PrintWriter out = response.getWriter();
		out.println("�ϴ��ɹ�"+wid+"%"+tid);
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/imgedit.jsp");
	}
	protected void getwid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tid=request.getParameter("tid");
		String state=request.getParameter("state");
		WorksDao wd=new WorksImpl();
		int wrno=wd.getmaxWid(tid, Integer.parseInt(state));
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/workinfoedit.jsp?wid="+wrno+"&tid="+tid);
	}
	
	protected void addcontent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tid=request.getParameter("tid");
		//String state=request.getParameter("state");
		String colid=request.getParameter("colid");
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		int wrid=Integer.parseInt(wid);
		String content=request.getParameter("editor");
		new CreatXML().addColContent(tid,wid,"0",colid,content);
		//PrintWriter out = response.getWriter();
		//out.println("�ϴ��ɹ�"+wid+"%"+tid+"%"+content+"%"+colid);
		//return;
		response.sendRedirect("http://localhost:8088/MProject_keyan/workedit/coledit.jsp");
	}
	
	protected void deleteall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.addHeader("P3P", "CP=CAO PSA OUR");
		WorkColumnDao wcd =new WorkColumnImpl();
		HttpSession session=request.getSession();
		if(session.getAttribute("wid")!=null && session.getAttribute("vid")!=null){
		String wid=session.getAttribute("wid").toString();
		String vid=session.getAttribute("vid").toString();
		String tid=session.getAttribute("tid").toString();
		int wrid=Integer.parseInt(wid);
		//ɾ��xml�еĽڵ�
		new delXML().delWorElement(tid, wid, "0");
		WorksDao wd=new WorksImpl();
		//ɾ��work
		wd.delwork(tid, Integer.parseInt(wid), 0);
		Video_imageDao vd=new Video_imageImpl();
		//ɾ��vi
		vd.deletevi(Integer.parseInt(vid));
		//ɾ����Ŀ
		wcd.deleteworkcol(tid, Integer.parseInt(session.getAttribute("wid").toString()),0);
		}
		PrintWriter out = response.getWriter();
		//out.println("�ϴ��ɹ�"+wid);
		response.sendRedirect("http://localhost:8088/MProject_keyan/MyWorks.jsp");
	}
	protected void saveall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		WorksDao wd=new WorksImpl();
		WorksBean alwb=new WorksBean();
		WorkColumnDao wcd =new WorkColumnImpl();
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		String vid=session.getAttribute("vid").toString();
		String tid=session.getAttribute("tid").toString();
		if(session.getAttribute("alwid")!=null &&session.getAttribute("alstate").equals(1)){
			alwb=wd.get(tid,Integer.parseInt(session.getAttribute("alwid").toString()),Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ��work
			wd.delwork(tid, Integer.parseInt(session.getAttribute("alwid").toString()), Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ����Ŀ
			wcd.deleteworkcol(tid, Integer.parseInt(session.getAttribute("alwid").toString()), Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ��vi
			Video_imageDao vimd=new Video_imageImpl();
			vimd.deletevi(Integer.parseInt(session.getAttribute("alvid").toString()));
			//ɾ��xml�е�work
			new delXML().delWorElement(tid, session.getAttribute("alwid").toString(), session.getAttribute("alstate").toString());
			session.removeAttribute("alwid");
		}
		//wb1Ϊ�մ����ĳɹ���΢��ΪҪת��Ϊ�ĳɹ�
		WorksBean wb1=new WorksBean();
		wb1=wd.get(tid,Integer.parseInt(wid), 0);	
		wd.delwork(tid, Integer.parseInt(wid), 0);
		//�½�һ��״̬��Ϊ1���³ɹ�
		int wid1=wd.addnewWork(tid, 1);
		WorksBean wb2=new WorksBean();
		wb2=wd.get(tid,wid1,1);			
		//WorksImpl wd=new WorksImpl();
		wd.changecreTosub(wb1,wb2);		
		wcd.updatstate(tid, Integer.parseInt(wid), 0, 1,wid1);
		new CreatXML().updatestate(tid, wid, "0","1",String.valueOf(wid1));
		/*PrintWriter out = response.getWriter();
		out.println("�ϴ��ɹ�"+wid1+wb2.getIntro());*/
		session.removeAttribute("wid");
		session.removeAttribute("vid");
		session.removeAttribute("alvid");
		session.removeAttribute("alstate");
		response.sendRedirect("http://localhost:8088/MProject_keyan/MyWorks.jsp");
	}
	
	protected void upall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		WorksDao wd=new WorksImpl();
		WorksBean alwb=new WorksBean();
		WorkColumnDao wcd =new WorkColumnImpl();
		response.addHeader("P3P", "CP=CAO PSA OUR");
		HttpSession session=request.getSession();
		String wid=session.getAttribute("wid").toString();
		String vid=session.getAttribute("vid").toString();
		String tid=session.getAttribute("tid").toString();
		if(session.getAttribute("alwid")!=null &&session.getAttribute("alstate").equals(1)){
			alwb=wd.get(tid,Integer.parseInt(session.getAttribute("alwid").toString()),Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ��work
			wd.delwork(tid, Integer.parseInt(session.getAttribute("alwid").toString()), Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ����Ŀ
			wcd.deleteworkcol(tid, Integer.parseInt(session.getAttribute("alwid").toString()), Integer.parseInt(session.getAttribute("alstate").toString()));
			//ɾ��vi
			Video_imageDao vimd=new Video_imageImpl();
			vimd.deletevi(Integer.parseInt(session.getAttribute("alvid").toString()));
			//ɾ��xml�е�work
			new delXML().delWorElement(tid, session.getAttribute("alwid").toString(), session.getAttribute("alstate").toString());
			session.removeAttribute("alwid");
		}
		
		WorksBean wb1=new WorksBean();
		//�½�һ��״̬��Ϊ2���³ɹ�
		int wid1=wd.addnewWork(tid, 2);
		//wb1Ϊ�մ����ĳɹ���΢��ΪҪת��Ϊ�ĳɹ�
		wb1=wd.get(tid,Integer.parseInt(wid), 0);
		WorksBean wb2=new WorksBean();
		wb2=wd.get(tid,wid1,2);
		//WorksImpl wd=new WorksImpl();
		wd.changecreTosub(wb1,wb2);
		wd.delwork(tid, Integer.parseInt(wid), 0);
		wcd.updatstate(tid, Integer.parseInt(wid), 0, 2,wid1);
		new CreatXML().updatestate(tid, wid, "0","2",String.valueOf(wid1));
		PrintWriter out = response.getWriter();
		out.println("�ϴ��ɹ�"+wid1+wb2.getIntro());
		session.removeAttribute("wid");
		session.removeAttribute("vid");
		session.removeAttribute("alvid");
		session.removeAttribute("alstate");
		response.sendRedirect("http://localhost:8088/MProject_keyan/MyWorks.jsp");
	}
}

