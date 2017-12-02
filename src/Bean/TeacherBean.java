package Bean;
//教师表
public class TeacherBean {
	private String Tch_no;//教师职工号
	private String Tch_name;//姓名
	private String password;//密码
	private String title;//职称
	private String dpmt;//所属院系
	private String email;//邮箱
	private int wrkNum;//成果数量
	private int wrkNumRcd;//成果自增编号

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
