/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: PointDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:02:35
*/
package cn.qingmukj.domain;

/**
 * @author gnosis
 * @version 1.0 成绩bean
 */
public class PointBean {
	private int pid;
	private String sid;
	private String cid;
	private String pgrade;
	private String psession;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPgrade() {
		return pgrade;
	}

	public void setPgrade(String pgrade) {
		this.pgrade = pgrade;
	}

	public String getPsession() {
		return psession;
	}

	public void setPsession(String psession) {
		this.psession = psession;
	}

}
