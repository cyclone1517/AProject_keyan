package Bean;

public class WorkColumnBean {
	int Col_no;
	int Wrk_no;
	String Col_name;
	String Col_content;
	String Tch_no;
	int state; /* ����������ˣ�����ˣ����� */

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

	public int getCol_no() {
		return Col_no;
	}

	public void setCol_no(int col_no) {
		Col_no = col_no;
	}

	public int getWrk_no() {
		return Wrk_no;
	}

	public void setWrk_no(int wrk_no) {
		Wrk_no = wrk_no;
	}

	public String getCol_name() {
		return Col_name;
	}

	public void setCol_name(String col_name) {
		Col_name = col_name;
	}

	public String getCol_content() {
		return Col_content;
	}

	public void setCol_content(String col_content) {
		Col_content = col_content;
	}

}
