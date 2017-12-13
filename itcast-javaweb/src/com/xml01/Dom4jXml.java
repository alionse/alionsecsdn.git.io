package com.xml01;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
*使用dom4j实现对xml文件的读取
*<P>Title:Dom4jXml.java</P>
*<P>Description</P>
*<P>Company:com.alionse</P>
* @author Alionse  
* @date 创建时间：Nov 30, 2017 11:37:40 PM
* @version 1.0
* @parameter 
*/
public class Dom4jXml {
	public static void main(String[] args) throws Exception {
		//1.获取解析器
		SAXReader reader = new SAXReader();
		//2.解析xml获取代表整个文档的dom对象
		Document dom = reader.read("book.xml");
		//3.获取根节点
		Element root = dom.getRootElement();
		//4.获取书名进行打印
		String bookName = root.element("书").element("书名").getText();
		System.out.println(bookName);
	}
}
