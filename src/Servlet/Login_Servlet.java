package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ManagerBean;
import Dao.ManagerDao;
import Impl.ManagerImpl;

public class Login_Servlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		String ide=req.getParameter("ide");
		//HttpSession session1=req.getSession();
		if(action.equals("iden")&&ide.equals("abc")){
			identity(req,resp);
		}
	}
	
	protected void identity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String identity=req.getParameter("identity");
		if(identity.equals("usr")){
			//loginusr(req,resp);
		}
		else if(identity.equals("bus")){
			//loginbus(req,resp);
		}
		else if(identity.equals("sys")){
			loginsys(req,resp);
		}
	}
	
	protected void loginsys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		ManagerDao dao=new ManagerImpl();
		ManagerBean Manager=new ManagerBean();
		Manager=dao.login(username, password);
		if(Manager!=null){
			HttpSession session=req.getSession();
			session.setAttribute("type1", "所有");
			session.setAttribute("type2", "不限");
			session.setAttribute("username", username); //save user info
			//req.getRequestDispatcher("SysControl.jsp").forward(req, resp);
			//resp.sendRedirect("http://localhost:8080/AProject_keyan/SysControl.jsp");
			resp.sendRedirect("http://localhost:8888/AProject_keyan/SysControl.jsp");
			//syslist(req,resp);
		}
		else{
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
}
