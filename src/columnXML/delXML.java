package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class delXML {
	public void delTeaElement(String teaid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]");
		node.getParent().remove(node);
		//ָ���ļ������λ��
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delWorElement(String teaid,String worid,String state){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]");
		node.getParent().remove(node);
		//ָ���ļ������λ��
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delColElement(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]");
		node.getParent().remove(node);
		//ָ���ļ������λ��
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delColContent(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]");
		node.setText("");
		//ָ���ļ������λ��
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new delXML().delTeaElement("201526010307");
		new delXML().delColContent("201526010308","1","1","1");
	}

}
