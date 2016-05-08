package com.wjb.testlog4j;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
//import org.omg.CORBA_2_3.portable.OutputStream;
/**
 * 用dom4j
 * 改xml配置文件中的值
 * @author vmuser
 *
 */
public class ModifyXML {
		
//		public static String filePath;
	/*	public static String configFilePath;
		static{
			try {
				//filePath = new URI(XmlUtils.class.getClassLoader().getResource("curInfo.txt").toString()).getPath();
				configFilePath = new URI(ModifyXML.class.getClassLoader().getResource("log4j.xml").toString()).getPath();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		public static void main(String[] args) {
				try {
					modifyXml_1("cpu","88");
				} catch (DocumentException e) {
					e.printStackTrace();
				}
		}
		
//		public static Document getDocument() throws DocumentException{
//			
//			SAXReader reader = new SAXReader();
//		    Document document = reader.read(new File(configFilePath));
//		    return document;
//		}
		
	/**
	 * 改xml配置文件中的值，仅限于简单的标签只含有单个的
	 * @param type
	 * @param value
	 * @throws DocumentException
	 */
	public static void modifyXml_1(String type, String value) throws DocumentException{
		String appenderName = null;
		String paramName =null;
		SAXReader reader = new SAXReader();
	    Document doc;
		doc = reader.read(new File("src/test.xml"));
		Element root = doc.getRootElement();
		List list = doc.selectNodes("Body/liminal");
		Iterator iter = list.iterator();
	   	 	    
	    while(iter.hasNext()){
			Element modEle = (Element)iter.next();
			if(type.equals("cpu")){
				modEle.element("cpu").setText(value);
			}else{
				
			}
	    }
	    writeXmlLocal(doc,"src/test.xml");//写myeclipse工程里的文件
		    
//		    Document doc1 = getDocument();
//		    List list1 = doc.selectNodes("Body/liminal");
//		    Iterator iter1 = list.iterator();
//		    while(iter1.hasNext()){
//				Element modEle = (Element)iter1.next();
//				if(type.equals("cpu")){
//					modEle.element("cpu").setText(value);
//				}else if(type.equals("ram")){
//					modEle.element("ram").setText(value);
//				}else if(type.equals("hdd")){
//					modEle.element("hdd").setText(value);
//				}
//		    }
//		    writeXmlLocal(doc1,configFilePath);//写tomcat部署的工程里的文件
	}
	
	public static void writeXmlLocal(Document doc,String Path){	
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(Path);
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			format.setIndent(true);
	        format.setIndent(" ");
			XMLWriter writer = new XMLWriter(fileOut,format);			
			writer.write(doc);	
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
/*########################################################*/	
	/**
	 * 改xml配置文件，可用于有好多相同的标签的xml配置文件
	 * @param type 无用
	 * @param value 无用
	 * @throws DocumentException
	 */
	public static void modifyXml_2(String type, String value) throws DocumentException{
		String appenderName = null;
		String paramName =null;
		SAXReader reader = new SAXReader();
	    Document doc = reader.read(new File("src/log4j.xml"));
	    Element root = doc.getRootElement();	    
	    List<Element> appenders = root.elements("appender");
	    for(int i = 0; i<appenders.size(); i++){
	    	appenderName = appenders.get(i).attributeValue("class");
			System.out.println("appenders name: " + appenderName);
			if(appenderName.contains("File")){
				System.out.println("File appender: " + appenderName);
				List<Element> params = appenders.get(i).elements("param");
				for(int j = 0; j<params.size(); j++){
					paramName = params.get(j).attributeValue("value");
					System.out.println("params name: " + paramName);
					if(paramName.contains("log")){
						params.get(j).addAttribute("value", "./订票服务/log.log");
					}
				}
			}
	    }
	    File file = new File("src/log4j.xml");
	    OutputStream os;
		try {
			os = new FileOutputStream(file);
		    XMLWriter writer;
		    writer = new XMLWriter(os, OutputFormat.createPrettyPrint());
			writer.write(doc);
			writer.flush();
			writer.close();
			os.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	    	    	 
	}
}
