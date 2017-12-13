package com.xml01;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
*
*<P>Title:Dom4jForXmlCRUD.java</P>
*<P>Description</P>
*<P>Company:com.alionse</P>
* @author Alionse  
* @date 创建时间：Nov 30, 2017 11:39:08 PM
* @version 1.0
* @parameter 
*/
public class Dom4jForXmlCRUD {
	@Test
	public void attr() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		
		Element bookEle = root.element("书");
		bookEle.addAttribute("出版社", "传智出版社");

		//获取属性的value值
//		String str = bookEle.attributeValue("出版社");


		Attribute attr = bookEle.attribute("出版社");
		attr.getParent().remove(attr);
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void del() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		
		Element price2Ele = root.element("书").element("特价");
		//内存中表示一个元素属于另一个元素的方法：在父类中的一个引用，所以删除一个元素，需要找到该元素的父亲，来删除。
		price2Ele.getParent().remove(price2Ele);

		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void update()throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		
		root.element("书").element("特价").setText("4.0元");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void add()throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		//凭空创建<特价>节点,设置标签体
		Element price2Ele = DocumentHelper.createElement("特价");
		price2Ele.setText("40.0元");
		//获取父标签<书>将特价节点挂载上去
		Element bookEle = root.element("书");
		bookEle.add(price2Ele);
		
		//将内存中的dom树会写到xml文件中,从而使xml中的数据进行更新
		//使用流时，一定要关闭流，否则会导致文件内容的丢失。因为流会存在缓冲区，如果不关闭流，结束程序后会使缓冲区关闭，导致文件内容丢失
//		FileWriter writer = new FileWriter("book.xml");
//		dom.write(writer);
//		writer.flush();
//		writer.close();
		//dom4j存在的特有的将内存中的内容写道文件中
		//将一个流包装在另一个流中，叫做：包装
		//OutputFormat.createPrettyPrint()是将文件的内容格式化，将文件内容格式美化
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void find() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		//获取所有的子标签对象
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		Element book2Ele = list.get(1);
		System.out.println(book2Ele.element("书名").getText());
		
	}

}
