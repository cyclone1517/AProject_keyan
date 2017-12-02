package Dao;

import java.util.List;
import Bean.TeacherBean;

public interface TeacherDao {
	public TeacherBean login(String userno,String password);//ͨ���û���ź������¼
	public void addTeacher(TeacherBean teacher);//��ӽ�ʦ
	public void updateTeacher(TeacherBean teacher);//���½�ʦ
	public void delTeac(String teacherno);//ɾ����ʦ
	public List<TeacherBean> query();//�������н�ʦ
	public List<TeacherBean> queryId(String id);//����ID���ҽ�ʦ
	public List<TeacherBean> queryDpmt(String dpmt);//����ѧԺ���ҽ�ʦ
	public List<TeacherBean> queryName(String name);//�����������ҽ�ʦ
	public TeacherBean get(String id);
}
