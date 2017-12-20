package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ManagerBean;
import Bean.TeacherBean;
import Dao.ManagerDao;
import Dao.TeacherDao;
import Impl.ManagerImpl;
import Impl.TeacherImpl;
import Util.ValiEmail;
import Util.ValiGenerator;

public class IndivCenter_Servlet extends HttpServlet{
	private String action;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		action=req.getParameter("action");
		//System.out.println(action);
		
		if(req.getParameter("action")!=null)
		{
			this.action = req.getParameter("action");
			if(action.equals("submit")){
				//do nothing
			}else if(action.equals("psdChange")){
				//System.out.println("entering psdChange...");
				changePassword(req,resp);
			}else if(action.equals("emailSending")){
				//System.out.println("you are sending ...");
				emailSending(req,resp);
			}else if(action.equals("emailSaving")){
				//System.out.println("you are saving ...");
				emailSaving(req,resp);
			}
		}
		
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
		
		String oldpsd = req.getParameter("oldpsd");
		String newpsd1 = req.getParameter("newpsd1");
		String newpsd2 = req.getParameter("newpsd2");
		
		PrintWriter out=resp.getWriter();
		
		if(!mbean.getPassword().equals(oldpsd)){
			out.print("<script language='javascript'>alert('原密码输入错误!');window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
			//out.print("<script language='javascript'>alert('原密码输入错误!');</script>"); 
			//req.getRequestDispatcher("PswdChange.jsp").forward(req, resp);
		}else if(newpsd1.length()<6){
			out.print("<script language='javascript'>alert('请输入6位以上的新密码!');window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else if(!newpsd1.equals(newpsd2)){
			out.print("<script language='javascript'>alert('确认密码和新密码不一致!');window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}else{
			mbean.setPassword(newpsd2);
			mdao.updateManager(mbean);
			out.print("<script language='javascript'>alert('您已成功修改密码!');window.location.href='subIndivCenter/PswdChange.jsp';</script>"); 
		}
		
		
	}
	
	protected void emailSending(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String receiveMail = req.getParameter("receiveMail"); 
		//System.out.println("RMainl is: " + receiveMail);
		String vcode = ValiGenerator.getRandom(6);
		
		ManagerDao mdao=new ManagerImpl();
		ManagerBean mbean = new ManagerBean();
		String username = (String)req.getSession().getAttribute("username");
		mbean = mdao.get(username);
		
		if(receiveMail==null || !receiveMail.contains("@")){	//邮箱不能为空，并且简单的格式检查，需要含@
			out.print("<script language='javascript'>alert('请输入正确的收件账号!');"
					+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>"); 
		}
		else if(receiveMail.equals(mbean.getEmail())){			//邮箱需要做出改变
			out.print("<script language='javascript'>alert('您的邮箱没有发生改变，将不会发送邮件!');"
					+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>"); 
		}
		else if(ValiEmail.send(receiveMail, "科研成果展示系统-邮箱绑定", vcode)){	//发送邮件
			HttpSession session=req.getSession();
			if(session.getAttribute("validation")==null){
				System.out.println("setting...");
				session.setAttribute("tmpEmail", receiveMail);
				session.setAttribute("validation", vcode);
				session.setMaxInactiveInterval(300);
				out.print("<script language='javascript'>alert('您已成功发送邮件, 请在3分钟内输入验证码!');"
						+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>"); 
			}else{
				out.print("<script language='javascript'>alert('邮件已发送，请勿重复发送!');"
						+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>"); 
			}
			
		}
		else{
			out.print("<script language='javascript'>alert('邮件发送失败, 请联系cyl1517@yeah.net!');"
					+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>");
		}
		//req.getRequestDispatcher("subIndivCenter/EmailSaving.jsp").forward(req, resp);
	}

	protected void emailSaving(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ManagerDao mdao=new ManagerImpl();
		ManagerBean mbean = new ManagerBean();
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		
		String username = (String)req.getSession().getAttribute("username");
		mbean = mdao.get(username);
		String entervali = req.getParameter("validation");
		
		if(entervali.equals((String)session.getAttribute("validation"))){
			mbean.setEmail((String)session.getAttribute("tmpEmail"));
			mdao.updateManager(mbean);
			
			//删除相关session,有效时间恢复30分钟
			session.removeAttribute("tmpEmail");
			session.removeAttribute("validation");
			session.setMaxInactiveInterval(1800);
			out.print("<script language='javascript'>alert('您的邮箱已经成功绑定!');"
					+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>");
		}else{
			out.print("<script language='javascript'>alert('您的验证码输入错误!');"
					+ "window.location.href='subIndivCenter/EmailSaving.jsp';</script>");
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
