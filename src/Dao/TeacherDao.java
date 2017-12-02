package Dao;

import java.util.List;
import Bean.TeacherBean;

public interface TeacherDao {
	public TeacherBean login(String userno,String password);//通过用户编号和密码登录
	public void addTeacher(TeacherBean teacher);//添加教师
	public void updateTeacher(TeacherBean teacher);//更新教师
	public void delTeac(String teacherno);//删除教师
	public List<TeacherBean> query();//查找所有教师
	public List<TeacherBean> queryId(String id);//根据ID查找教师
	public List<TeacherBean> queryDpmt(String dpmt);//根据学院查找教师
	public List<TeacherBean> queryName(String name);//根据姓名查找教师
	public TeacherBean get(String id);
}
