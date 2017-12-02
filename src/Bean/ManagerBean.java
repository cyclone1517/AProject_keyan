package Bean;
//管理员表
public class ManagerBean {
	private String Mng_no;// 管理员职工号
	private String Mng_name;// 姓名
	private String password;// 密码
	private String email;// 邮箱
	private String dpmt;// 所属院系

	public String getDpmt() {
		return dpmt;
	}

	public void setDpmt(String dpmt) {
		this.dpmt = dpmt;
	}

	public String getMng_no() {
		return Mng_no;
	}

	public void setMng_no(String mng_no) {
		Mng_no = mng_no;
	}

	public String getMng_name() {
		return Mng_name;
	}

	public void setMng_name(String mng_name) {
		Mng_name = mng_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
