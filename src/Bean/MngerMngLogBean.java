package Bean;
//ҵ��Ա������־ 

import java.util.Date;

public class MngerMngLogBean {
	private String Mng_no;//����Աְ����
	private String Sys_Mng_no;//ҵ�����Աְ����
	private Date operTime;//����ʱ�䣬
	private int oper_no;//��������

	public String getMng_no() {
		return Mng_no;
	}

	public void setMng_no(String mng_no) {
		Mng_no = mng_no;
	}

	public String getSys_Mng_no() {
		return Sys_Mng_no;
	}

	public void setSys_Mng_no(String sys_Mng_no) {
		Sys_Mng_no = sys_Mng_no;
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
