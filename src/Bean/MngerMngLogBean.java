package Bean;
//业务员管理日志 

import java.util.Date;

public class MngerMngLogBean {
	private String Mng_no;//管理员职工号
	private String Sys_Mng_no;//业务管理员职工号
	private Date operTime;//操作时间，
	private int oper_no;//操作种类

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
