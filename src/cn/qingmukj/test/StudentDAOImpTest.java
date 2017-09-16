/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: StudentDAOImpTest.java
* Copyright 2017-06-13 By Gnosis. Allright reserved.
* Time: 上午10:56:22
*/
package cn.qingmukj.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.qingmukj.dao.StudentDAO;
import cn.qingmukj.dao.imp.StudentDAOImp;
import cn.qingmukj.domain.StudentBean;

public class StudentDAOImpTest {

	@Test
	public void test() {
		StudentDAO studentdao = new StudentDAOImp();
		List<StudentBean> list = studentdao.getTotalStudentInfo();

		for (int i = 0; i < list.size(); ++i) {
			System.out.println("uid:" + list.get(i).getUid() + ",sid" + list.get(i).getSid());
		}
	}

	@Test
	public void testDelete() {
		StudentDAO studentdao = new StudentDAOImp();
		
		studentdao.deleteStudent("1410074101");
	}
}
