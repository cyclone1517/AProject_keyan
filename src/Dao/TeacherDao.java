package Dao;

import java.util.List;
import Bean.TeacherBean;

public interface TeacherDao {
	public TeacherBean login(String userno,String password);//通过用户编号和密码登录
	public void addTeacher(TeacherBean teacher);//添加教师
	public void updateTeacher(TeacherBean teacher);//更新教师
	public void delTeac(String teacherno);//删除教师
	public List<TeacherBean> query(int id);//查找所有教师
	public List<TeacherBean> query1(int id);//查找所有教师
	public List<TeacherBean> queryId(int no,String id);//根据ID查找教师
	public List<TeacherBean> queryId1(int no,String id);//根据ID查找教师
	public List<TeacherBean> queryDpmt(int no,String dpmt);//根据学院查找教师
	public List<TeacherBean> queryDpmt1(int no,String dpmt);//根据学院查找教师
	public List<TeacherBean> queryName(int no,String name);//根据姓名查找教师
	public List<TeacherBean> queryName1(int no,String name);//根据姓名查找教师
	public TeacherBean get(String id);
}
