package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ManagerBean;
import Bean.TeacherBean;
import Dao.ManagerDao;
import Dao.RoleOfUserDao;
import Dao.TeacherDao;
import Impl.ManagerImpl;
import Impl.RoleOfUserImpl;
import Impl.TeacherImpl;



public class Mng_Servlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String ide=req.getParameter("ide");
		if(action.equals("list")&&ide.equals("sys")){
			syslist(req,resp);
		}
		else if(action.equals("query")&&ide.equals("sys")){
			String type1 = new String(req.getParameter("type1").getBytes("iso-8859-1"), "utf-8");
			String type2 = new String(req.getParameter("type2").getBytes("iso-8859-1"), "utf-8");
			String keywords = new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");
			//String type1=req.getParameter("type1");
			//String type2=req.getParameter("type2");
			//String keywords=req.getParameter("keywords");
			HttpSession session=req.getSession();
			session.setAttribute("type1", type1);
			session.setAttribute("type2", type2);
			session.setAttribute("keywords", keywords);
			if((keywords.equals("")||type2.equals("����"))&&type1.equals("����")){
				list(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("�û�ID")){
				listqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("ѧԺ")){
				listquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("����")){
				listqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ϵͳ����Ա")){
				syslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("�û�ID")){
				sysqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("ѧԺ")){
				sysquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("����")){
				sysqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("��ʦ")){
				tchlist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("�û�ID")){
				tchqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("ѧԺ")){
				tchquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("����")){
				tchqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ҵ�����Ա")){
				buslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("�û�ID")){
				busqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("ѧԺ")){
				busquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("����")){
				busqueryname(req,resp);
			}
		}
		else if(action.equals("queryagain")&&ide.equals("sys")){
			HttpSession session=req.getSession();
			String type1=(String)session.getAttribute("type1");
			String type2=(String)session.getAttribute("type2");
			String keywords=(String)session.getAttribute("keywords");
			if((keywords.equals("")||type2.equals("����"))&&type1.equals("����")){
				list(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("�û�ID")){
				listqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("ѧԺ")){
				listquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("����")){
				listqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ϵͳ����Ա")){
				syslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("�û�ID")){
				sysqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("ѧԺ")){
				sysquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("����")){
				sysqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("��ʦ")){
				tchlist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("�û�ID")){
				tchqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("ѧԺ")){
				tchquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("����")){
				tchqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ҵ�����Ա")){
				buslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("�û�ID")){
				busqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("ѧԺ")){
				busquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("����")){
				busqueryname(req,resp);
			}
		}
		else if(action.equals("delete")&&ide.equals("sys")){
			deletesys(req,resp);
		}
		else if(action.equals("delete")&&ide.equals("tch")){
			deletetch(req,resp);
		}
		else if(action.equals("delete")&&ide.equals("bus")){
			deletebus(req,resp);
		}
		else if(action.equals("add")&&ide.equals("sys")){
			String sys="H",bus="H",tch="H";
			if(req.getParameter("sys")!=null){
				sys=new String(req.getParameter("sys").getBytes("iso-8859-1"), "utf-8");
			}
			if(req.getParameter("bus")!=null){
				bus=new String(req.getParameter("bus").getBytes("iso-8859-1"), "utf-8");
			}
			if(req.getParameter("tch")!=null){
				tch=new String(req.getParameter("tch").getBytes("iso-8859-1"), "utf-8");
			}
			if(sys.equals("ϵͳ����Ա")){
				addsys(req,resp);
			}
			if(bus.equals("ҵ�����Ա")&&!sys.equals("ϵͳ����Ա")){
				addbus(req,resp);
			}
			else if(bus.equals("ҵ�����Ա")&&sys.equals("ϵͳ����Ա")){
				addbus2(req,resp);
			}
			if(tch.equals("��ʦ")){
				addtch(req,resp);
			}
			HttpSession session=req.getSession();
			session.setAttribute("type1", "����");
			session.setAttribute("type2", "����");
			list(req,resp);
		}
		else if(action.equals("get")&&ide.equals("sys")){
			getsys(req,resp);
		}
		else if(action.equals("update")&&ide.equals("sys")){
			String tch="";
			if(req.getParameter("tch")!=null){
				tch=new String(req.getParameter("tch").getBytes("iso-8859-1"), "utf-8");
			}
			HttpSession session=req.getSession();
			String tch1=(String) session.getAttribute("tchmark");
			if(!tch1.equals("2")&&tch.equals("��ʦ")){
				addtch1(req,resp);
			}
			else if(tch1.equals("2")&&tch.equals("��ʦ")){
				updatetch(req,resp);
			}
			else if(tch1.equals("2")&&!tch.equals("��ʦ")){
				deletetch1(req,resp);
			}
			String sys="";
			if(req.getParameter("sys")!=null){
				sys=new String(req.getParameter("sys").getBytes("iso-8859-1"), "utf-8");
			}
			String sys1=(String)session.getAttribute("sysmark");
			if(!sys1.equals("1")&&sys.equals("ϵͳ����Ա")){
				addsys1(req,resp);
			}
			else if(sys1.equals("1")&&sys.equals("ϵͳ����Ա")){
				updatesys(req,resp);
			}
			else if(sys1.equals("1")&&!sys.equals("ϵͳ����Ա")){
				deletesys1(req,resp);
			}
			String bus="";
			if(req.getParameter("bus")!=null){
				bus=new String(req.getParameter("bus").getBytes("iso-8859-1"), "utf-8");
			}
			String bus1=(String)session.getAttribute("busmark");
			if(!bus1.equals("3")&&bus.equals("ҵ�����Ա")){
				addbus1(req,resp);
			}
			else if(bus1.equals("3")&&bus.equals("ҵ�����Ա")){
				updatebus(req,resp);
			}
			else if(bus1.equals("3")&&!bus.equals("ҵ�����Ա")){
				deletebus1(req,resp);
			}
			queryagain(req,resp);
		}
	}
	
	protected void updatebus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		ManagerBean bean=new ManagerBean();
		bean.setDpmt(dpmt);
		bean.setMng_no(no);
		dao.updateManager(bean);
	}
	
	protected void addbus1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		if(dao.get(no)==null){	
			TeacherDao daoo=new TeacherImpl();
			TeacherBean tch=daoo.get(no);
			ManagerBean manager=new ManagerBean();
			manager.setDpmt(dpmt);
			manager.setMng_name(name);
			manager.setMng_no(no);
			manager.setEmail(tch.getEmail());
			dao.addManager(manager);
		}
		dao1.addRU(3, no);
	}
	
	protected void deletebus1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("no");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.delRU(3, id);
	}
	
	protected void deletesys1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("no");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.delRU(1, id);
	}
	
	protected void addsys1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		if(dao.get(no)==null){	
			TeacherDao daoo=new TeacherImpl();
			TeacherBean tch=daoo.get(no);
			ManagerBean manager=new ManagerBean();
			manager.setDpmt(dpmt);
			manager.setMng_name(name);
			manager.setMng_no(no);
			manager.setEmail(tch.getEmail());
			dao.addManager(manager);
		}
		dao1.addRU(1, no);
	}
	
	protected void updatesys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		ManagerBean bean=new ManagerBean();
		bean.setDpmt(dpmt);
		bean.setMng_no(no);
		dao.updateManager(bean);
	}
	
	protected void deletetch1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("no");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.delRU(2, id);
	}
	
	protected void queryagain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String type1=(String)session.getAttribute("type1");
		String type2=(String)session.getAttribute("type2");
		String keywords=(String)session.getAttribute("keywords");
		if((keywords.equals("")||type2.equals("����"))&&type1.equals("����")){
			list(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("�û�ID")){
			listqueryno(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("ѧԺ")){
			listquerydpmt(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("����")&&type2.equals("����")){
			listqueryname(req,resp);
		}
		else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ϵͳ����Ա")){
			syslist(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("�û�ID")){
			sysqueryno(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("ѧԺ")){
			sysquerydpmt(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ϵͳ����Ա")&&type2.equals("����")){
			sysqueryname(req,resp);
		}
		else if((keywords.equals("")||type2.equals("����"))&&type1.equals("��ʦ")){
			tchlist(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("�û�ID")){
			tchqueryno(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("ѧԺ")){
			tchquerydpmt(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("��ʦ")&&type2.equals("����")){
			tchqueryname(req,resp);
		}
		else if((keywords.equals("")||type2.equals("����"))&&type1.equals("ҵ�����Ա")){
			buslist(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("�û�ID")){
			busqueryno(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("ѧԺ")){
			busquerydpmt(req,resp);
		}
		else if(!keywords.equals("")&&type1.equals("ҵ�����Ա")&&type2.equals("����")){
			busqueryname(req,resp);
		}
	}
	
	protected void updatetch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String no=req.getParameter("no");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		String job=new String(req.getParameter("job").getBytes("iso-8859-1"), "utf-8");
		TeacherBean bean=new TeacherBean();
		bean.setDpmt(dpmt);
		bean.setTch_no(no);
		bean.setTitle(job);
		dao.updateTeacher(bean);
	}
	
	protected void addtch1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		ManagerDao daoo=new ManagerImpl();
		ManagerBean bean=daoo.get(no);
		String email=bean.getEmail();
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		String job=new String(req.getParameter("job").getBytes("iso-8859-1"), "utf-8");
		if(dao.get(no)==null){
			TeacherBean tch=new TeacherBean();
			tch.setDpmt(dpmt);
			tch.setEmail(email);
			tch.setTch_name(name);
			tch.setTch_no(no);
			tch.setTitle(job);
			dao.addTeacher(tch);
		}
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.addRU(2, no);
		//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void getsys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		RoleOfUserDao dao=new RoleOfUserImpl();
		List<String> ss=dao.queryUserno(id);
		String sysmark="0",tchmark="0",busmark="0";
		for(String s:ss){
			if(s.equals("ϵͳ����Ա")){
				sysmark="1";
			}
			if(s.equals("��ʦ")){
				tchmark="2";
			}
			if(s.equals("ҵ�����Ա")){
				busmark="3";
			}
		}
		HttpSession session=req.getSession();
		session.setAttribute("sysmark", sysmark);
		session.setAttribute("tchmark", tchmark);
		session.setAttribute("busmark", busmark);
		if(tchmark.equals("2")){
			TeacherDao dao1=new TeacherImpl();
			TeacherBean bean=dao1.get(id);
			req.setAttribute("bean", bean);
			req.getRequestDispatcher("SysUpdate.jsp").forward(req, resp);
		}
		else{
			if(sysmark.equals("1")){
				ManagerDao dao1=new ManagerImpl();
				ManagerBean bean=dao1.get(id);
				req.setAttribute("bean2", bean);
				req.getRequestDispatcher("SysUpdate.jsp").forward(req, resp);
			}
			else if(busmark.equals("3")){
				ManagerDao dao1=new ManagerImpl();
				ManagerBean bean=dao1.get(id);
				req.setAttribute("bean3", bean);
				req.getRequestDispatcher("SysUpdate.jsp").forward(req, resp);
			}
		}
	}
	
	protected void addsys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String email=req.getParameter("email");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		//System.out.println("mng_servlet 133: "+dpmt);
		ManagerBean manager=new ManagerBean();
		manager.setDpmt(dpmt);
		manager.setEmail(email);
		manager.setMng_name(name);
		manager.setMng_no(no);
		dao.addManager(manager);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.addRU(1, no);
		
		//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void addbus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String email=req.getParameter("email");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		ManagerBean manager=new ManagerBean();
		manager.setDpmt(dpmt);
		manager.setEmail(email);
		manager.setMng_name(name);
		manager.setMng_no(no);
		dao.addManager(manager);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.addRU(3, no);
		//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void addbus2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no=req.getParameter("no");
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.addRU(3, no);
		//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void addtch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String no=req.getParameter("no");
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String email=req.getParameter("email");
		String dpmt=new String(req.getParameter("dpmt").getBytes("iso-8859-1"), "utf-8");
		String job=new String(req.getParameter("job").getBytes("iso-8859-1"), "utf-8");
		TeacherBean tch=new TeacherBean();
		tch.setDpmt(dpmt);
		tch.setEmail(email);
		tch.setTch_name(name);
		tch.setTch_no(no);
		tch.setTitle(job);
		dao.addTeacher(tch);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.addRU(2, no);
		//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void buslist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdent(3);
		req.setAttribute("list2", list);
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdno(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<ManagerBean> list=dao.queryIddpmt(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<ManagerBean> list=dao.queryIdname(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		List<TeacherBean> list1=dao1.query1(2);
		req.setAttribute("list1", list1);
		//System.out.println(list+"before");
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.query();
		req.setAttribute("list", list);
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	/*	for(ManagerBean t:list){
			System.out.println("mng_serlvet 233"+t.getDpmt());
		}*/
	}
	
	protected void listqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list1=dao1.queryId1(2,keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryno(keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void listquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list1=dao1.queryDpmt1(2,keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.querydpmt(keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void listqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list1=dao1.queryName1(2,keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryname(keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		List<TeacherBean> list=dao.query(2);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list=dao.queryId(2,keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list=dao.queryDpmt(2,keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<TeacherBean> list=dao.queryName(2,keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void syslist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdent(1);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void sysqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<ManagerBean> list=dao.queryIdno(1, keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void sysquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<ManagerBean> list=dao.queryIddpmt(1, keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void sysqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords="";
		if(req.getParameter("keywords")!=null){
			keywords=new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");//req.getParameter("keywords");
		}
		else{
			HttpSession session=req.getSession();
			keywords=(String)session.getAttribute("keywords");
		}
		List<ManagerBean> list=dao.queryIdname(1, keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void deletesys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		ManagerDao dao=new ManagerImpl();
		ManagerBean bean=dao.get(id);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.del(id);
		TeacherDao dao2=new TeacherImpl();
		TeacherBean bean2=dao2.get(id);
		if(bean2!=null){
			dao2.delTeac(id);
		}
		if(bean!=null){
			dao.delManager(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("ϵͳ����Ա")&&(keywords.equals("")||type2.equals("����"))){
				syslist(req,resp);
			}
			else if(type1.equals("ϵͳ����Ա")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					sysqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					sysquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					sysqueryname(req,resp);
				}
			}
			else if(type1.equals("����")&&(keywords.equals("")||type2.equals("����"))){
				list(req,resp);
			}
			else if(type1.equals("����")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					listqueryname(req,resp);
				}
			}
		}
	}
	
	protected void deletetch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		TeacherDao dao=new TeacherImpl();
		TeacherBean bean=dao.get(id);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.del(id);
		ManagerDao dao2=new ManagerImpl();
		ManagerBean bean2=dao2.get(id);
		if(bean2!=null){
			dao2.delManager(id);
		}
		if(bean!=null){
			dao.delTeac(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("��ʦ")&&keywords.equals("")){
				tchlist(req,resp);
			}
			else if(type1.equals("��ʦ")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					tchqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					tchquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					tchqueryname(req,resp);
				}
			}
			else if(type1.equals("����")&&(keywords.equals("")||type2.equals("����"))){
				list(req,resp);
			}
			else if(type1.equals("����")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					listqueryname(req,resp);
				}
			}
		}
	}
	
	protected void deletebus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		ManagerDao dao=new ManagerImpl();
		ManagerBean bean=dao.get(id);
		RoleOfUserDao dao1=new RoleOfUserImpl();
		dao1.del(id);
		TeacherDao dao2=new TeacherImpl();
		TeacherBean bean2=dao2.get(id);
		if(bean2!=null){
			dao2.delTeac(id);
		}
		if(bean!=null){
			dao.delManager(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("ҵ�����Ա")&&keywords.equals("")){
				buslist(req,resp);
			}
			else if(type1.equals("ҵ�����Ա")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					busqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					busquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					busqueryname(req,resp);
				}
			}
			else if(type1.equals("����")&&(keywords.equals("")||type2.equals("����"))){
				list(req,resp);
			}
			else if(type1.equals("����")&&!keywords.equals("")){
				if(type2.equals("�û�ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("ѧԺ")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("����")){
					listqueryname(req,resp);
				}
			}
		}
	}
}
