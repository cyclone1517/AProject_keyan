package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ManagerBean;
import Bean.TeacherBean;
import Dao.ManagerDao;
import Dao.TeacherDao;
import Impl.ManagerImpl;
import Impl.TeacherImpl;

public class IndivCenter_Servlet extends HttpServlet{
	private String action;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String action=req.getParameter("action");
		if(req.getParameter("action")!=null)
		{
			this.action = req.getParameter("action");
			if(action.equals("submit"))
			{
				/*changeUserInfo(req,resp);*/
			}else if(action.equals("psdChange")){
				changePassword(req,resp);
			}
		}
		/*else if(action.equals("query")){
			String type1 = new String(req.getParameter("type1").getBytes("iso-8859-1"), "utf-8");
			String type2 = new String(req.getParameter("type2").getBytes("iso-8859-1"), "utf-8");
			String keywords = new String(req.getParameter("keywords").getBytes("iso-8859-1"), "utf-8");
			HttpSession session=req.getSession();
			session.setAttribute("type1", type1);
			session.setAttribute("type2", type2);
			session.setAttribute("keywords", keywords);
		}*/
	}
	
	/*这个函数没有用上*/
	protected void changeUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String dpmt = req.getParameter("dpmt");
		String no = req.getParameter("no");
		TeacherDao tdao=new TeacherImpl();
		TeacherBean tbean = new TeacherBean();
		tbean.setTitle(title);
		tdao.updateTeacher(tbean);
	}
	
	protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao mdao=new ManagerImpl();
		ManagerBean mbean = new ManagerBean();
		String username = (String)req.getSession().getAttribute("username");
		mbean = mdao.get(username);
		
		String oldpwd = req.getParameter("oldpwd");
		String newpwd1 = req.getParameter("newpwd1");
		String newpwd2 = req.getParameter("newpwd2");
		System.out.println(oldpwd + ", " + newpwd1 + ", " + newpwd2);
		
		PrintWriter out=resp.getWriter();
		//in java '==' just means compare the index
		if(!mbean.getPassword().equals(oldpwd)){
			out.print("<script language='javascript'>alert('原密码输入错误!');"
					+ "window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else if(newpwd1==null || newpwd1==""){
			out.print("<script language='javascript'>alert('请输入新密码!');"
					+ "window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else if(newpwd2==null || newpwd1==""){
			out.print("<script language='javascript'>alert('请重复输入新密码!');"
					+ "window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else if(!newpwd1.equals(newpwd2)){
			out.print("<script language='javascript'>alert('两次输入的密码不一致，请重新输入!');"
					+ "window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else{
			mbean.setPassword(newpwd2);
			mdao.updateManager(mbean);
			out.print("<script language='javascript'>alert('您已成功修改密码!');"
					+ "window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}	
	}
	
	protected void tchqueryno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao dao=new TeacherImpl();
		String keywords=req.getParameter("keywords");
		List<TeacherBean> list=dao.queryId(0, keywords);
		req.setAttribute("list1", list);
		//System.out.println(list+"before");
		req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
	}
}
