package Bean;

import java.util.Date;

public class WorkCheckBean {
	int Wrk_no;// �ɹ����
	String Tch_no;
	int state; /* ����������ˣ�����ˣ����� */
	String Mng_no;// ����Ա���
	Date operTime;// ����ʱ��
	int oper_no;// �������
	public String getTch_no() {
		return Tch_no;
	}

	public void setTch_no(String tch_no) {
		Tch_no = tch_no;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getWrk_no() {
		return Wrk_no;
	}

	public void setWrk_no(int wrk_no) {
		Wrk_no = wrk_no;
	}

	public String getMng_no() {
		return Mng_no;
	}

	public void setMng_no(String mng_no) {
		Mng_no = mng_no;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public int getOper_no() {
		return oper_no;
	}

	public void setOper_no(int oper_no) {
		this.oper_no = oper_no;
	}

}
