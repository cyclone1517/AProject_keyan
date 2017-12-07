package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
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
	public void addTeaElement(String teaid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("WorkColumn.xml"));
		//Node node = document.selectSingleNode("//title");
		Element root = document.getRootElement();//���ڵ�
		Element teacher=root.addElement("teacher");
		teacher.addAttribute("tid", teaid);
		//ָ���ļ������λ��
        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
        // ָ���ı���д���ĸ�ʽ��
        OutputFormat format=OutputFormat.createPrettyPrint();   //Ư����ʽ���пո���
        format.setEncoding("UTF-8");
        //1.����д������
        XMLWriter writer=new XMLWriter(out,format);
        writer.setEscapeText(false);
        //2.д��Document����
		writer.write(document);
        //3.�ر���
        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
	}
	
	public void addWorElement(String teaid,String worid,String state){
		SAXReader reader = new SAXReader();
		try {
		 Document document;
		document = reader.read(new File("WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]");
		//Iterator iter = (Iterator) list.iterator();
		 Element element=(Element)node;
		 Element work=element.addElement("work");
		 work.addAttribute("wid", worid);
		 work.addAttribute("state", state);
		//ָ���ļ������λ��
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
	        // ָ���ı���д���ĸ�ʽ��
	        OutputFormat format=OutputFormat.createPrettyPrint();   //Ư����ʽ���пո���
	        format.setEncoding("UTF-8");
	        //1.����д������
	        XMLWriter writer=new XMLWriter(out,format);
	        writer.setEscapeText(false);
	        //2.д��Document����
			writer.write(document);			
	        //3.�ر���
	        writer.close();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void addColElement(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		 Document document;
		document = reader.read(new File("WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]");
		//Iterator iter = (Iterator) list.iterator();
		 Element element=(Element)node;
		 Element column=element.addElement("column");
		 column.addAttribute("cid", colid);
		//ָ���ļ������λ��
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
	        // ָ���ı���д���ĸ�ʽ��
	        OutputFormat format=OutputFormat.createPrettyPrint();   //Ư����ʽ���пո���
	        format.setEncoding("UTF-8");
	        //1.����д������
	        XMLWriter writer=new XMLWriter(out,format);
	        //2.д��Document����
			writer.write(document);			
	        //3.�ر���
	        writer.close();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void addColContent(String teaid,String worid,String state,String colid,String content){
		SAXReader reader = new SAXReader();  
		try {
		 Document document = reader.read(new File("WorkColumn.xml"));
		 Node node = document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]"); 
		 node.setText(content);
		 	//ָ���ļ������λ��
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
	        // ָ���ı���д���ĸ�ʽ��
	        OutputFormat format=OutputFormat.createPrettyPrint();   //Ư����ʽ���пո���
	        format.setEncoding("UTF-8");
	        //1.����д������
	        XMLWriter writer=new XMLWriter(out,format);
	        writer.setEscapeText(false);
	        //2.д��Document����
			writer.write(document);	
	        //3.�ر���
	        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new CreatXML().createXML();
		//new CreatXML().addTeaElement("201526010307");
		//new CreatXML().addWorElement("201526010307","1","1");
		//new CreatXML().addColElement("201526010307","1","1","2");
		String content="չʾϵͳ�ɹ�һ�����ԵĲ�<sdas>-=kNullam hendrerit justo non leo aliquet imperdiet. Etiam in sagittis lectus. Suspendisse ultrices placerat accumsan. Mauris quis dapibus orci. In dapibus velit blandit pharetra tincidunt. Quisque non sapien nec lacus condimentum facilisis ut iaculis enim. Sed viverra interdum bibendum. Donec ac sollicitudin dolor. Sed fringilla vitae lacus at rutrum. Phasellus congue vestibulum ligula sed consequat.";
		new CreatXML().addColContent("201526010307","1","1","2",content);
	}

}
