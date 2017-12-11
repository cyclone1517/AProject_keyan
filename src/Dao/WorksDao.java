package Dao;

import java.util.Date;
import java.util.List;

import Bean.WorksBean;

public interface WorksDao {
	public void addwork(WorksBean work);
	public int getvi_id();
	public void delwork(String Tch_no,String Wrk_no,int state);
	//�ı�ɹ�״̬���������ύ����ˣ������޸ĵĻ�Ϊ����һ������/�ύ�ı���˺��滻ȫ���ķ���ı���Щ������ͬ
	//�������ύ
	public void changecreTosub(String Tch_no, String Wrk_no);
	//�ύ�����
	public void changesubTopas(String Tch_no, String Wrk_no);
	//��˱����
	public void changepasTodel(String Tch_no, String Wrk_no);
	//����ȫ���ɹ���Ĭ��Ϊ����
	public List<WorksBean> query();
	//����ĳ����ʦ���ϴ��ĳɹ���������ʾ�ڸ��˳ɹ���//����ĳ����ʦ�Ѵ����ĳɹ���������ʾ�ڸ��˳ɹ���
	public List<WorksBean> querycreid(String Tch_no,int state);
	//��ʾ���е����ύ�ɹ�//��ʾ���е�����˳ɹ�
	public List<WorksBean> querystate(int state);
	//������˳ɹ��а����ɹ��������
	public List<WorksBean> queryalworkid(String Wrk_no);
	//�������⣬ʱ�䣬�ͱ�ǩ����
	public List<WorksBean> query(String Type_name,Date startTime,Date endTime,String wlabel);
	public List<WorksBean> querycli(String Type_name,Date startTime,Date endTime,String wlabel);
	//������������
	public List<WorksBean> querytype(String Type_name);
	public List<WorksBean> querytypecli(String Type_name);
	//����ʱ������
	public List<WorksBean> querytime(Date startTime,Date endTime);
	public List<WorksBean> querytimecli(Date startTime,Date endTime);
	//���ձ�ǩ����
	public List<WorksBean> querylabel(String wlabel);
	public List<WorksBean> querylabelcli(String wlabel);
	//��������ʱ������
	public List<WorksBean> querytytime(String Type_name,Date startTime,Date endTime);
	public List<WorksBean> querytytimecli(String Type_name,Date startTime,Date endTime);
	//�������ǩ����
	public List<WorksBean> querytylab(String Type_name,String wlabel);
	public List<WorksBean> querytylabcli(String Type_name,String wlabel);
	//��ʱ���ǩ����
	public List<WorksBean> querylabtime(String wlabel,Date startTime,Date endTime);
	public List<WorksBean> querylabtimecli(String wlabel,Date startTime,Date endTime);
	public WorksBean get(String Tch_no,String Wrk_no,int state);
}
