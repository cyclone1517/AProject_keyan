package Bean;
//��ʦ��
public class TeacherBean {
	private String Tch_no;//��ʦְ����
	private String Tch_name;//����
	private String password;//����
	private String title;//ְ��
	private String dpmt;//����Ժϵ
	private String email;//����
	private int wrkNum;//�ɹ�����
	private int wrkNumRcd;//�ɹ��������

	public String getTch_no() {
		return Tch_no;
	}

	public void setTch_no(String tch_no) {
		Tch_no = tch_no;
	}

	public String getTch_name() {
		return Tch_name;
	}

	public void setTch_name(String tch_name) {
		Tch_name = tch_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDpmt() {
		return dpmt;
	}

	public void setDpmt(String dpmt) {
		this.dpmt = dpmt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWrkNum() {
		return wrkNum;
	}

	public void setWrkNum(int wrkNum) {
		this.wrkNum = wrkNum;
	}

	public int getWrkNumRcd() {
		return wrkNumRcd;
	}

	public void setWrkNumRcd(int wrkNumRcd) {
		this.wrkNumRcd = wrkNumRcd;
	}

}
