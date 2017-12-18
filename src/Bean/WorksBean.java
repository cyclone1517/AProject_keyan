package Bean;

import java.util.Date;

public class WorksBean {
	int Wrk_no;
	String Tch_no;
	int state; /* 创建，待审核，已审核，禁用 */
	String Type_ID; /* 类型编号 */
	int VI_no; /* 视频图片编号 */
	String Wrk_name; /* 成果名称 */
	String wlabel; /* 标签 */
	String intro; /* mysql要求最大255 */
	Date createTime; /* 创建时间 */
	Date checkTime; /* 审核时间 */
	Date submitTime; /* 提交时间 */
	int countNum; /* 点击次数 */

	public int getWrk_no() {
		return Wrk_no;
	}

	public void setWrk_no(int wrk_no) {
		Wrk_no = wrk_no;
	}

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

	public String getType_ID() {
		return Type_ID;
	}

	public void setType_ID(String type_ID) {
		Type_ID = type_ID;
	}

	public int getVI_no() {
		return VI_no;
	}

	public void setVI_no(int vI_no) {
		VI_no = vI_no;
	}

	public String getWrk_name() {
		return Wrk_name;
	}

	public void setWrk_name(String wrk_name) {
		Wrk_name = wrk_name;
	}

	public String getWlabel() {
		return wlabel;
	}

	public void setWlabel(String wlabel) {
		this.wlabel = wlabel;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

}
