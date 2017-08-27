/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: SettingDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:02:46
*/
package cn.qingmukj.domain;

/**
 * @author gnosis
 * @version 1.0 设置表bean
 */
public class SettingBean {
	private int setid;
	private String setname;
	private String setvalue;
	private String setdesc;

	public int getSetid() {
		return setid;
	}

	public void setSetid(int setid) {
		this.setid = setid;
	}

	public String getSetname() {
		return setname;
	}

	public void setSetname(String setname) {
		this.setname = setname;
	}

	public String getSetvalue() {
		return setvalue;
	}

	public void setSetvalue(String setvalue) {
		this.setvalue = setvalue;
	}

	public String getSetdesc() {
		return setdesc;
	}

	public void setSetdesc(String setdesc) {
		this.setdesc = setdesc;
	}

}
