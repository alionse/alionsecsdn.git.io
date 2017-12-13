package com.xml01;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
*
*<P>Title:SaxforXMl.java</P>
*<P>Description</P>
*<P>Company:com.alionse</P>
* @author Alionse  
* @date ����ʱ�䣺Nov 30, 2017 11:27:11 PM
* @version 1.0
* @parameter 
*/
public class SaxforXMl {
	public static void main(String[] args) throws Exception {
		//1.��ȡ����������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.ͨ��������ȡsax������
		SAXParser parser = factory.newSAXParser();
		//3.��ȡ��ȡ��
		XMLReader reader = parser.getXMLReader();
		//4.ע���¼�������
		//reader.setContentHandler(new MyContentHandler2());
		//5.����xml
		reader.parse("book.xml");	
	}

//���������ģʽ
//DefaultHandler��ʵ����ContentHandler�ӿ�
class MyContentHandler2 extends DefaultHandler{
	private String eleName = null;
	private int count = 0;
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		this.eleName = name;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("����".equals(eleName) && ++count==2){
			System.out.println(new String(ch,start,length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		eleName = null;
	}
	
}

class MyContentHandler implements ContentHandler{

	
	@Override
	public void setDocumentLocator(Locator locator) {
		
	}

	
	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		
	}
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}

	
}
}
