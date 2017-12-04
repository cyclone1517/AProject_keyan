package Bean;

import java.util.Date;

//成果审核表
public class WorkCheck {
	String Wrk_no;//成果编号
	String Mng_no;//管理员编号
	Date operTime;//操作时间
	int oper_no;//操作编号

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
