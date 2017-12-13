package com.xml01;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
*ʹ��dom4jʵ�ֶ�xml�ļ��Ķ�ȡ
*<P>Title:Dom4jXml.java</P>
*<P>Description</P>
*<P>Company:com.alionse</P>
* @author Alionse  
* @date ����ʱ�䣺Nov 30, 2017 11:37:40 PM
* @version 1.0
* @parameter 
*/
public class Dom4jXml {
	public static void main(String[] args) throws Exception {
		//1.��ȡ������
		SAXReader reader = new SAXReader();
		//2.����xml��ȡ���������ĵ���dom����
		Document dom = reader.read("book.xml");
		//3.��ȡ���ڵ�
		Element root = dom.getRootElement();
		//4.��ȡ�������д�ӡ
		String bookName = root.element("��").element("����").getText();
		System.out.println(bookName);
	}
}
