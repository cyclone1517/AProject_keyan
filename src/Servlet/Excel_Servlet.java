package Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import Bean.ManagerBean;
import Bean.TeacherBean;
import Dao.ManagerDao;
import Dao.RoleOfUserDao;
import Dao.TeacherDao;
import Impl.ManagerImpl;
import Impl.RoleOfUserImpl;
import Impl.TeacherImpl;
import Util.Util;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_Servlet extends HttpServlet{
	
	public void getDate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errMessage = null;
        boolean flags=false;

        List liststu = new ArrayList();
        // 找到上传后的文件目录,并创建IO流
        java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("")+"\\upload\\staff.xls");
        InputStream is = new FileInputStream(f);
        try {
            // 创建工作簿
            Workbook wb = Workbook.getWorkbook(is);
            // 创建工作表
            jxl.Sheet sheet = wb.getSheet(0);
            String content = null;
            for (int i = 1; i < sheet.getRows(); i++) {
                ManagerBean staff = new ManagerBean();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    content = sheet.getCell(j, i).getContents();
                    // System.out.print(content);
                    if (staff.getMng_no() == null)//
                    {
                        staff.setMng_no(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getMng_name() == null) {
                        staff.setMng_name(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getPassword() == null) {
                        staff.setPassword(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getEmail() == null) {
                        staff.setEmail(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getDpmt() == null) {
                        staff.setDpmt(sheet.getCell(j, i).getContents());
                        continue;
                    }
                }
                flags=getStaffInfo(staff);
            }
            /*
             * 文件导入成功后进入提示界面
             */
            if(flags){
                System.out.println("总表导入成功!");
                response.sendRedirect("http://localhost:8080/AProject_keyan/SysControl.jsp");
            }else{
                System.out.println("总表未导入成功!");
               // errMessage = "导入总表未成功,请重新导入！";
               // request.setAttribute("error", errMessage);
                //request.getRequestDispatcher("../tips.jsp").forward(request,response);
            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    *sql的添加方法,此方法也可以写到Dao文件,然后再servlet中调用;
    */
	public boolean getStaffInfo(ManagerBean staff) {
        boolean flag=false;
        Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql = "insert into Manager(Mng_no,Mng_name,password,email,dpmt) values (?,?,?,?,?)";
        Util jdbc = new Util();
        conn = jdbc.openConnection();
        ManagerDao dao=new ManagerImpl();
        if(dao.get(staff.getMng_no())==null){
        	RoleOfUserDao dao1=new RoleOfUserImpl();
        	dao1.addRU(1, staff.getMng_no());
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1, staff.getMng_no());
            pt.setString(2, staff.getMng_name());
            pt.setString(3, staff.getPassword());
            pt.setString(4, staff.getEmail());
            pt.setString(5, staff.getDpmt());
            int n=pt.executeUpdate();
            if(n>0){
                flag=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
        if(dao.get(staff.getMng_no())!=null){
        	flag=true;
        }
        return flag;
    }
	
	public boolean getStaffInfo2(ManagerBean staff) {
        boolean flag=false;
        Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql = "insert into Manager(Mng_no,Mng_name,password,email,dpmt) values (?,?,?,?,?)";
        Util jdbc = new Util();
        conn = jdbc.openConnection();
        ManagerDao dao=new ManagerImpl();
        if(dao.get(staff.getMng_no())==null){
        	RoleOfUserDao dao1=new RoleOfUserImpl();
        	dao1.addRU(3, staff.getMng_no());
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1, staff.getMng_no());
            pt.setString(2, staff.getMng_name());
            pt.setString(3, staff.getPassword());
            pt.setString(4, staff.getEmail());
            pt.setString(5, staff.getDpmt());
            int n=pt.executeUpdate();
            if(n>0){
                flag=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
        if(dao.get(staff.getMng_no())!=null){
        	flag=true;
        }
        return flag;
    }
	
	public boolean getStaffInfo1(TeacherBean staff) {
        boolean flag=false;
        Connection conn = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        String sql = "insert into Teacher(Tch_no,Tch_name,password,title,dpmt,email) values(?,?,?,?,?,?)";
        Util jdbc = new Util();
        conn = jdbc.openConnection();
        TeacherDao dao=new TeacherImpl();
        if(dao.get(staff.getTch_no())==null){
            RoleOfUserDao dao1=new RoleOfUserImpl();
        	dao1.addRU(2, staff.getTch_no());
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1, staff.getTch_no());
            pt.setString(2, staff.getTch_name());
            pt.setString(3, staff.getPassword());
            pt.setString(4, staff.getTitle());
            pt.setString(5, staff.getDpmt());
            pt.setString(6, staff.getEmail());
            
            int n=pt.executeUpdate();
            if(n>0){
                flag=true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        }
        if(dao.get(staff.getTch_no())!=null){
        	flag=true;
        }
        return flag;
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        if (type.equals("excToMqsql")) {
            /*
            *先对文件进行上传,代码如下
            */
            SmartUpload su = new SmartUpload();
            su.initialize(this.getServletConfig(), req, resp);
            // 设定允许上传的文件（通过扩展名限制）
            su.setAllowedFilesList("xls,xlsx");
            try {
                su.upload();
                Files files = su.getFiles();
                String temp = "";
                for (int i = 0; i < files.getCount(); i++) {
                    File file = files.getFile(i);
                    temp = "/upload/staff.xls";//将上传的文件放在根目录下的upload文件夹下并命名为固定的文件名
                    file.saveAs(temp, SmartUpload.SAVE_VIRTUAL);//将文件进行上传
                }
                System.out.println("上传成功!");
                /*
                *文件上传成功后,将调用文件导入的方法;
                */
               // InStaff es = new InStaff();//创建自身对象;
                //es.
                String identity =su.getRequest().getParameter("identity");
                if(identity.equals("sys")){
                	getDate(req, resp);//调用导入Excel数据的方法;
                }
                else if(identity.equals("bus")){
                	getDate1(req,resp);
                }
                else if(identity.equals("tch")){
                	getDate2(req,resp);
                }

                // ExcelToMySql(request, response);
            } catch (SmartUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
	
	public void getDate1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errMessage = null;
        boolean flags=false;

        List liststu = new ArrayList();
        // 找到上传后的文件目录,并创建IO流
        java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("")+"\\upload\\staff.xls");
        InputStream is = new FileInputStream(f);
        try {
            // 创建工作簿
            Workbook wb = Workbook.getWorkbook(is);
            // 创建工作表
            jxl.Sheet sheet = wb.getSheet(0);
            String content = null;
            for (int i = 1; i < sheet.getRows(); i++) {
                ManagerBean staff = new ManagerBean();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    content = sheet.getCell(j, i).getContents();
                    // System.out.print(content);
                    if (staff.getMng_no() == null)//
                    {
                        staff.setMng_no(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getMng_name() == null) {
                        staff.setMng_name(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getPassword() == null) {
                        staff.setPassword(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getEmail() == null) {
                        staff.setEmail(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getDpmt() == null) {
                        staff.setDpmt(sheet.getCell(j, i).getContents());
                        continue;
                    }
                }
                flags=getStaffInfo2(staff);	
            }
            /*
             * 文件导入成功后进入提示界面
             */
            if(flags){
                System.out.println("总表导入成功!");
                response.sendRedirect("http://localhost:8080/AProject_keyan/SysControl.jsp");
            }else{
                System.out.println("总表未导入成功!");
               // errMessage = "导入总表未成功,请重新导入！";
               // request.setAttribute("error", errMessage);
                //request.getRequestDispatcher("../tips.jsp").forward(request,response);
            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void getDate2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errMessage = null;
        boolean flags=false;

        List liststu = new ArrayList();
        // 找到上传后的文件目录,并创建IO流
        java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("")+"\\upload\\staff.xls");
        InputStream is = new FileInputStream(f);
        try {
            // 创建工作簿
            Workbook wb = Workbook.getWorkbook(is);
            // 创建工作表
            jxl.Sheet sheet = wb.getSheet(0);
            String content = null;
            for (int i = 1; i < sheet.getRows(); i++) {
                TeacherBean staff = new TeacherBean();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    content = sheet.getCell(j, i).getContents();
                    // System.out.print(content);
                    if (staff.getTch_no() == null)//
                    {
                        staff.setTch_no(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getTch_name() == null) {
                        staff.setTch_name(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getPassword() == null) {
                        staff.setPassword(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getEmail() == null) {
                        staff.setEmail(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getDpmt() == null) {
                        staff.setDpmt(sheet.getCell(j, i).getContents());
                        continue;
                    }
                    if (staff.getTitle() == null) {
                        staff.setTitle(sheet.getCell(j, i).getContents());
                        continue;
                    }
                }
                flags=getStaffInfo1(staff);
            }
            /*
             * 文件导入成功后进入提示界面
             */
            if(flags){
                System.out.println("总表导入成功!");
                response.sendRedirect("http://localhost:8080/AProject_keyan/SysControl.jsp");
            }else{
                System.out.println("总表未导入成功!");
               // errMessage = "导入总表未成功,请重新导入！";
               // request.setAttribute("error", errMessage);
                //request.getRequestDispatcher("../tips.jsp").forward(request,response);
            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
