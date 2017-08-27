/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: ConvertStringNumEct.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 下午3:29:12
*/
package cn.qingmukj.util;

public class ConvertStringNumEct {
	public static int convertJudge(String str) {
		int num = -29262609;
		switch (str) {
		case "admin":
			num = 1;
			break;
		case "mgr":
			num = 2;
			break;
		case "stu":
			num = 3;
			break;
		}
		return num;
	}
}
