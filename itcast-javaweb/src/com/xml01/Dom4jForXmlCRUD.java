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
* @date ����ʱ�䣺Nov 30, 2017 11:39:08 PM
* @version 1.0
* @parameter 
*/
public class Dom4jForXmlCRUD {
	@Test
	public void attr() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		
		Element bookEle = root.element("��");
		bookEle.addAttribute("������", "���ǳ�����");

		//��ȡ���Ե�valueֵ
//		String str = bookEle.attributeValue("������");


		Attribute attr = bookEle.attribute("������");
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
		
		Element price2Ele = root.element("��").element("�ؼ�");
		//�ڴ��б�ʾһ��Ԫ��������һ��Ԫ�صķ������ڸ����е�һ�����ã�����ɾ��һ��Ԫ�أ���Ҫ�ҵ���Ԫ�صĸ��ף���ɾ����
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
		
		root.element("��").element("�ؼ�").setText("4.0Ԫ");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void add()throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		//ƾ�մ���<�ؼ�>�ڵ�,���ñ�ǩ��
		Element price2Ele = DocumentHelper.createElement("�ؼ�");
		price2Ele.setText("40.0Ԫ");
		//��ȡ����ǩ<��>���ؼ۽ڵ������ȥ
		Element bookEle = root.element("��");
		bookEle.add(price2Ele);
		
		//���ڴ��е�dom����д��xml�ļ���,�Ӷ�ʹxml�е����ݽ��и���
		//ʹ����ʱ��һ��Ҫ�ر���������ᵼ���ļ����ݵĶ�ʧ����Ϊ������ڻ�������������ر���������������ʹ�������رգ������ļ����ݶ�ʧ
//		FileWriter writer = new FileWriter("book.xml");
//		dom.write(writer);
//		writer.flush();
//		writer.close();
		//dom4j���ڵ����еĽ��ڴ��е�����д���ļ���
		//��һ������װ����һ�����У���������װ
		//OutputFormat.createPrettyPrint()�ǽ��ļ������ݸ�ʽ�������ļ����ݸ�ʽ����
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"),OutputFormat.createPrettyPrint());
		writer.write(dom);
		writer.close();
	}
	
	@Test
	public void find() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom = reader.read("book.xml");
		Element root = dom.getRootElement();
		//��ȡ���е��ӱ�ǩ����
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		Element book2Ele = list.get(1);
		System.out.println(book2Ele.element("����").getText());
		
	}

}
