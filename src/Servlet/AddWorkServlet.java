package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Video_imageBean;
import Bean.WorksBean;
import Dao.Video_imageDao;
import Dao.WorksDao;
import Impl.Video_imageImpl;
import Impl.WorksImpl;

/**
 * Servlet implementation class AddWorkServlet
 */
@WebServlet("/AddWorkServlet")
public class AddWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
		String action=request.getParameter("action");
		String ide=request.getParameter("ide");
		if(action.equals("addwork")&&ide.equals("work"))
		{
			addwork(request,response);
		}
	}
	protected void addwork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String workno=request.getParameter("wid");
		String workname=request.getParameter("wname");
		String wlabel=request.getParameter("wlabel");
		String type=request.getParameter("type");
		String intro=request.getParameter("intro");
		WorksBean work=new WorksBean();
		WorksDao wd=new WorksImpl();
		work.setWrk_no(workno);
		work.setWrk_name(workname);
		work.setWlabel(wlabel);
		work.setType_ID(type);
		work.setTch_no(request.getParameter("tid"));
		work.setIntro(intro);
		wd.addwork(work);
		HttpSession session=request.getSession();
		WorksDao wsd=new WorksImpl();
		int vino=wsd.getvi_id();
		Video_imageBean vib=new Video_imageBean();
		Video_imageDao vd=new Video_imageImpl();
		vib.setVI_no(vino);
		vd.addvi(vib);
		session.setAttribute("vino", vino);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("上传成功");
		//request.getRequestDispatcher("/workedit/imgedit.jsp").forward(request, response);	
		//response.sendRedirect("../workedit/imgedit.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
