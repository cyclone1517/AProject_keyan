package Bean;
//��ʦ������־ 
import java.util.Date;

public class TeacMngLogBean {
	private String Tch_no;//��ʦְ����
	private String Mng_no;//����Աְ����
	private Date operTime;//����ʱ��
	private int oper_no;//��������

	public String getTch_no() {
		return Tch_no;
	}

	public void setTch_no(String tch_no) {
		Tch_no = tch_no;
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
