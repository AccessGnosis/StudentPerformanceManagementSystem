/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: MysqlInfo.java
* Copyright 2017-03-16 By Gnosis. Allright reserved.
* Time: ����8:21:38
*/
package cn.qingmukj.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MysqlInfo {
	public static final String XML_URL = "WebContent/WEB-INF/mysqlconfig.xml";

	public static String getDriverName() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = db.parse(XML_URL);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		Node node = document.getElementsByTagName("drivername").item(0);
		return node.getTextContent();
	}

	public static String getUrl() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = db.parse(XML_URL);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		String content = document.getElementsByTagName("url").item(0).getTextContent();
		return content;
	}

	public static String getUrlAttribute() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_URL)
					.getElementsByTagName("urlattribute").item(0).getTextContent();
		} catch (DOMException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDatabaseURL(String databaseName) {
		return getUrl() + databaseName + getUrlAttribute();
	}

	public static String getUserName() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_URL)
					.getElementsByTagName("username").item(0).getTextContent();
		} catch (DOMException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getPassword() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_URL)
					.getElementsByTagName("password").item(0).getTextContent();
		} catch (DOMException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
