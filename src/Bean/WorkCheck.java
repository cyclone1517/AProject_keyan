package Bean;

import java.util.Date;

//�ɹ���˱�
public class WorkCheck {
	String Wrk_no;//�ɹ����
	String Mng_no;//����Ա���
	Date operTime;//����ʱ��
	int oper_no;//�������

	public String getWrk_no() {
		return Wrk_no;
	}

	public void setWrk_no(String wrk_no) {
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
