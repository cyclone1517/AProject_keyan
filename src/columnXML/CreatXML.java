package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class CreatXML {
	public void createXML()
	{
		//创建Document对象,代表整个xml文档
		Document document= DocumentHelper.createDocument();
		//创建根节点
		Element rss=document.addElement("rss");
		//向rss文件中添加rss
		rss.addAttribute("version", "2.0");
		//设置生成xml的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		//生成文件
		File file=new File("WorkColumn.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addlabel(String id){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CreatXML().createXML();
	}

}
