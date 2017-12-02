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
		else if(action.equals("get")&&ide.equals("sys")){
			
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
			if((keywords.equals("")||type2.equals("不限"))&&type1.equals("所有")){
				list(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("所有")&&type2.equals("用户ID")){
				listqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("所有")&&type2.equals("学院")){
				listquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("所有")&&type2.equals("姓名")){
				listqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("不限"))&&type1.equals("系统管理员")){
				syslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("系统管理员")&&type2.equals("用户ID")){
				sysqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("系统管理员")&&type2.equals("学院")){
				sysquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("系统管理员")&&type2.equals("姓名")){
				sysqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("不限"))&&type1.equals("教师")){
				tchlist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("教师")&&type2.equals("用户ID")){
				tchqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("教师")&&type2.equals("学院")){
				tchquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("教师")&&type2.equals("姓名")){
				tchqueryname(req,resp);
			}
			else if((keywords.equals("")||type2.equals("不限"))&&type1.equals("业务管理员")){
				buslist(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("业务管理员")&&type2.equals("用户ID")){
				busqueryno(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("业务管理员")&&type2.equals("学院")){
				busquerydpmt(req,resp);
			}
			else if(!keywords.equals("")&&type1.equals("业务管理员")&&type2.equals("姓名")){
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
	}
	
	protected void buslist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdent(3);
		req.setAttribute("list2", list);
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keywords=req.getParameter("keywords");
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdno(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords=req.getParameter("keywords");
		List<ManagerBean> list=dao.queryIddpmt(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void busqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords=req.getParameter("keywords");
		List<ManagerBean> list=dao.queryIdname(3, keywords);
		req.setAttribute("list2", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		List<TeacherBean> list1=dao1.query();
		req.setAttribute("list1", list1);
		//System.out.println(list+"before");
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdent(1);
		req.setAttribute("list", list);
		List<ManagerBean> list2=dao.queryIdent(3);
		req.setAttribute("list2", list2);
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void listqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list1=dao1.queryId(keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdno(1, keywords);
		req.setAttribute("list", list);
		List<ManagerBean> list2=dao.queryIdno(3, keywords);
		req.setAttribute("list2", list2);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void listquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list1=dao1.queryDpmt(keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIddpmt(1, keywords);
		req.setAttribute("list", list);
		List<ManagerBean> list2=dao.queryIddpmt(3, keywords);
		req.setAttribute("list2", list2);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void listqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao1=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list1=dao1.queryName(keywords);
		req.setAttribute("list1", list1);
		
		ManagerDao dao=new ManagerImpl();
		List<ManagerBean> list=dao.queryIdname(1, keywords);
		req.setAttribute("list", list);
		List<ManagerBean> list2=dao.queryIdname(3, keywords);
		req.setAttribute("list2", list2);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		List<TeacherBean> list=dao.query();
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list=dao.queryId(keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list=dao.queryDpmt(keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void tchqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list=dao.queryName(keywords);
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
		String keywords=req.getParameter("keywords");
		List<ManagerBean> list=dao.queryIdno(1, keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void sysquerydpmt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords=req.getParameter("keywords");
		List<ManagerBean> list=dao.queryIddpmt(1, keywords);
		req.setAttribute("list", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
	
	protected void sysqueryname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao dao=new ManagerImpl();
		String keywords=req.getParameter("keywords");
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
		if(bean!=null){
			dao.delManager(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("系统管理员")&&(keywords.equals("")||type2.equals("不限"))){
				syslist(req,resp);
			}
			else if(type1.equals("系统管理员")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					sysqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					sysquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
					sysqueryname(req,resp);
				}
			}
			else if(type1.equals("所有")&&(keywords.equals("")||type2.equals("不限"))){
				list(req,resp);
			}
			else if(type1.equals("所有")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
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
		if(bean!=null){
			dao.delTeac(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("教师")&&keywords.equals("")){
				tchlist(req,resp);
			}
			else if(type1.equals("教师")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					tchqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					tchquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
					tchqueryname(req,resp);
				}
			}
			else if(type1.equals("所有")&&(keywords.equals("")||type2.equals("不限"))){
				list(req,resp);
			}
			else if(type1.equals("所有")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
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
		if(bean!=null){
			dao.delManager(id);
			HttpSession session=req.getSession();
			String type1=(String) session.getAttribute("type1");
			String type2=(String) session.getAttribute("type2");
			String keywords=(String) session.getAttribute("keywords");
			if(type1.equals("业务管理员")&&keywords.equals("")){
				buslist(req,resp);
			}
			else if(type1.equals("业务管理员")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					busqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					busquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
					busqueryname(req,resp);
				}
			}
			else if(type1.equals("所有")&&(keywords.equals("")||type2.equals("不限"))){
				list(req,resp);
			}
			else if(type1.equals("所有")&&!keywords.equals("")){
				if(type2.equals("用户ID")){
					listqueryno(req,resp);
				}
				else if(type2.equals("学院")){
					listquerydpmt(req,resp);
				}
				else if(type2.equals("姓名")){
					listqueryname(req,resp);
				}
			}
		}
	}
}
