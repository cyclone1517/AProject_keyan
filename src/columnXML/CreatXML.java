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
		//����Document����,��������xml�ĵ�
		Document document= DocumentHelper.createDocument();
		//�������ڵ�
		Element rss=document.addElement("rss");
		//��rss�ļ������rss
		rss.addAttribute("version", "2.0");
		//��������xml�ĸ�ʽ
		OutputFormat format=OutputFormat.createPrettyPrint();
		//�����ļ�
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
